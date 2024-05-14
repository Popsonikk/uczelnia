const user = require("../models/user");
const asyncHandler = require('express-async-handler');
const { body, validationResult } = require("express-validator");
const User = require("../models/user");
exports.user_add_get = (req, res, next) => {
    res.render("user_form", { title: "Add users"});};
exports.user_list = asyncHandler(async (req,res, next) => {
    const all_users = await user.find({}).exec();
    res.render("user_list", { title: "Users",user_list: all_users });});
    
exports.user_add_post = [
    // Walidacja i sanityzacja danych z formularza.
    body("first_name")
    .trim()
    .isLength({ min: 2 })
    .escape()
    .withMessage("First name too short."),
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
    // Przetwarzanie danych po walidacji i sanityzacji
    asyncHandler(async (req, res, next) => {
    // Pozyskanie z request obiektu błędu i jego ewentualna obsługa.
    const errors = validationResult(req);
    // Tworzenie obiektu User po 'oczyszczeniu' danych
    const user = new User({
    first_name: req.body.first_name,
    last_name: req.body.last_name,
    username: req.body.username,
    });    
    if (!errors.isEmpty()) {
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