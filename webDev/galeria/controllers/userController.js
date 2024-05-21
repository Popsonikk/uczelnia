// Import modułów z modelam.
const User = require("../models/user");

// Import funkcji obsługi wyjątków/błedów wywołań asynchronicznych.
const asyncHandler = require("express-async-handler");

// Import funkcji walidatora.
const { body, validationResult } = require("express-validator");

const bcrypt = require("bcrypt")
const jwt = require("jsonwebtoken");


// Kontroler listy userów.
exports.user_list = asyncHandler(async (req, res, next) => {
  const all_users = await User.find({}).exec();
  res.render("user_list", { title: "List of all users:", user_list: all_users });
});

// Kontroler wyświetlania formularza dodawania nowego usera - GET.
exports.user_add_get = (req, res, next) => {
  res.render("user_form", { title: "Add users" });
};

// Kontroler obsługi danych formularza dodawania nowego usera - POST.
exports.user_add_post = [
  // Walidacja i sanityzacja danych z formularza.
  body("first_name")
    .trim()
    .isLength({ min: 2 })
    .escape()
    .withMessage("First name too short."),

  // Własny middleware w kontrolerze - test
  // (req, res, next) => {console.log('Z kontrolera user..'); 
  // next()},	

  body("last_name")
    .trim()
    .isLength({ min: 2 })
    .escape()
    .withMessage("Last name name too short."),

  body("username", "Username must contain at least 3 characters")
    .trim()
    .isLength({ min: 3 })
    .escape()
    .isAlpha()
    .withMessage("Username must be alphabet letters."),

  body("password")
    .trim()
    .isLength({ min: 5 }).withMessage("Password must be at least 5 characters long.")
    .matches(/\d/).withMessage("Password must contain at least one number."),




  // Przetwarzanie danych po walidacji i sanityzacji.
  asyncHandler(async (req, res, next) => {
    // Pozyskanie z request obiektu błędu i jego ewentualna obsługa.
    const errors = validationResult(req);
    const hashedPassword = await bcrypt.hash(req.body.password, 10);

    // Tworzenie obiektu User po 'oczyszczeniu' danych. 
    const user = new User({
      first_name: req.body.first_name,
      last_name: req.body.last_name,
      username: req.body.username,
      password: hashedPassword,
    });

    if (!errors.isEmpty()) {
      // Jeśli pojawiły się błędy - ponownie wyrenderuj formularz i wypełnij pola 
      // wprowadzonymi danymi po sanityzacji.
      user.password = "",
        res.render("user_form", {
          title: "Add user:",
          user: user,
          errors: errors.array(),
        });
      return;
    } else {
      // Dane z formularza są poprawne.
      // Należy jeszcze sprawdzić czy w bazie istnieje już użytkownik
      // o tym samym username.
      const userExists = await User.findOne({ username: req.body.username })
        .collation({ locale: "en", strength: 2 })
        .exec();
      if (userExists) {
        // Błąd - użytkownik już istnieje w bazie, przekierowanie na stronę błędu.
        // res.redirect("/users");
        res.send("User exists");
      } else {
        await user.save();
        // Nowy użytkownik dodany - przekieruj wywołanie na listę userów.
        res.redirect("/users");
      }
    }
  }),
];

exports.user_login_get = (req, res, next) => {
  res.render("user_login_form", { title: "Login" });
};

exports.user_login_post = (req, res, next) => {
  let username = req.body.username
  let password = req.body.password
  User.findOne({ username })
    .then((user) => {
      if (user) {
        bcrypt.compare(password, user.password, function (err, result) {
          if (err) {
            res.json({
              error: err
            })
          }
          if (result) {
            // console.log(user.username)
            let token = jwt.sign({ username: user.username }, 'kodSzyfrujacy', { expiresIn: '1h' })
            res.cookie('mytoken', token, { maxAge: 600000 })
            //res.render('index', { title: 'Express', logged_user: username});
            res.render('index', { title: 'Express' });
          } else {
            res.json({
              message: 'Złe hasło'
            })
          }
        })
      } else {
        res.json({
          message: 'No user found!'
        })
      }
    })
}

exports.user_logout_get = (req, res, next) => {
  res.clearCookie('mytoken', {
    sameSite: 'strict',
    httpOnly: true,
    signed: false
  });
  res.redirect('/');
};