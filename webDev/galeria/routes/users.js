var express = require('express');
var router = express.Router();

const user_controller = require("../controllers/userController");

//USERS GET (/users)
router.get("/", user_controller.user_list);

//USER ADD GET (/users/user_add)
router.get("/user_add", user_controller.user_add_get);

//USER ADD POST (/users/user_add)
router.post("/user_add", user_controller.user_add_post);

module.exports = router;
