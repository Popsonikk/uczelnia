const gallery = require("../models/gallery");
const asyncHandler = require("express-async-handler");
const User = require("../models/user");
const Gallery = require("../models/gallery");
const { body, validationResult } = require("express-validator");

exports.gallery_list = asyncHandler(async (req, res, next) => {
 const all_galleries = await gallery.find({}).populate("user").exec();
 res.render("gallery_list", { title: "List of all galleries:", gallery_list: all_galleries });});

 exports.gallery_add_get = asyncHandler(async (req, res, next) => {
    const all_users = await User.find().sort({last_name:1}).exec();
   res.render("gallery_form", {title: "Add gallery",users: all_users,}); });

exports.gallery_add_post = [

    body("name")
    .trim()
    .isLength({ min: 2 })
    .escape()
    .withMessage("name too short."),
    body("description")
    .trim()
    .isLength({ min: 5 })
    .escape()
    .withMessage("description too short."),
    
    asyncHandler(async (req, res, next) => {

    const errors = validationResult(req);
    
    const gallery = new Gallery({
    name: req.body.name,
    description: req.body.description,
    user: req.body.user,
    });    
    if (!errors.isEmpty()) {
        
        const all_users = await User.find().sort({last_name:1}).exec();

        res.render("gallery_form", {
        title: "Add gallery:",
        gallery: gallery,
        users: all_users,
        errors: errors.array(),
        });
        return;
        } else {
        
        const galleryExists = await Gallery.findOne({
            name: req.body.name,
            user: req.body.user,})
            .collation({ locale: "en", strength: 2 })
            .exec();
        if (galleryExists) {
        
        res.send("Gallery exists");
        } else {
        await gallery.save();
        
        res.redirect("/gallery");
        }
        }
        }),
       ];
