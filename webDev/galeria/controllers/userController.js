
const asyncHandler = require('express-async-handler');
const { body, validationResult } = require("express-validator");
const User = require("../models/user");
// Import modułów do szyfrowania i autentykacji
const bcrypt = require("bcrypt")
const jwt = require("jsonwebtoken");




exports.user_list = asyncHandler(async (req, res, next) => {
    const all_users = await User.find({}).exec();
    res.render("user_list", { title: "Users", user_list: all_users });
});

exports.user_add_get = (req, res, next) => { res.render("user_form", { title: "Add users" }); };

exports.user_add_post = [
    // Walidacja i sanityzacja danych z formularza.
    body("first_name").trim().isLength({ min: 2 }).escape().withMessage("First name too short."),
    body("last_name").trim().isLength({ min: 2 }).escape().withMessage("Last name too short."),
    body("username", "Username must contain at least 3 characters").trim().isLength({ min: 3 }).escape().isAlpha().withMessage("Username must be alphabet letters."),
    // Przetwarzanie danych po walidacji i sanityzacji
    asyncHandler(async (req, res, next) => {
        // Pozyskanie z request obiektu błędu i jego ewentualna obsługa.
        const errors = validationResult(req);
        // Tworzenie obiektu User po 'oczyszczeniu' danych
        const hash=await bcrypt.hash(req.body.password, 10);
        const user = new User({
            first_name: req.body.first_name,
            last_name: req.body.last_name,
            username: req.body.username,
            password: hash,
        }); if (!errors.isEmpty()) {
            // Jeśli pojawiły się błędy - ponownie wyrenderuj formularz i wypełnij pola
            // wprowadzonymi danymi po sanityzacji.
            res.render("user_form", {
                title: "Add user:",
                user: user,
                errors: errors.array(),
            });
            return;
        } else {
            // Dane z formularza są poprawne.
            // Należy jeszcze sprawdzid czy w bazie istnieje już użytkownik
            // o tym samym username
            const userExists = await User.findOne({ username: req.body.username })
                .collation({ locale: "en", strength: 2 })
                .exec();
            if (userExists) {
                // Błąd - użytkownik już istnieje w bazie, przekierowanie na stronę błędu
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

// Kontroler wyświetlania formularza logowania - GET.
exports.user_login_get = (req, res, next) => {
    res.render("user_login_form", { title: "Login" });
};
exports.user_login_post = (req, res, next) => {
    let username = req.body.username;
    let password = req.body.password;

    User.findOne({ username })
        .then((user) => {
            if (user) {
                bcrypt.compare(password, user.password, function (err, result) {
                    if (err) {
                        return res.json({ error: err });
                    }
                    if (result) {
                        let token = jwt.sign({ username: user.username }, 'kodSzyfrujacy', { expiresIn: '1h' });
                        res.cookie('mytoken', token, { 
                            maxAge: 600000, // 10 minutes
                            httpOnly: true, // Prevents JavaScript access to the cookie
                            secure: true, // Ensures the cookie is sent only over HTTPS
                            sameSite: 'Strict' // Ensures the cookie is sent only with same-site requests
                        });
                        res.render('index', { title: 'Express' });
                    } else {
                        res.json({ message: 'Złe hasło' });
                    }
                });
            } else {
                res.json({ message: 'No user found!' });
            }
        })
        .catch(next); // handle errors
};
exports.user_logout_get = (req, res, next) => {
    res.clearCookie('mytoken', {
    sameSite: 'strict',
    httpOnly: true,
    signed: false
    });
    res.redirect('/');
   };
