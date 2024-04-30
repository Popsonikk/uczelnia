const user = require("../models/user");
const asyncHandler = require('express-async-handler');
exports.user_list = asyncHandler(async (req,res, next) => {
    const all_users = await user.find({}).exec();
    res.render("user_list", { title: "Users",user_list: all_users });});