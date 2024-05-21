var express = require('express');
var router = express.Router();

const image_controller = require("../controllers/imageController");

// IMAGES GET (/images)
router.get("/", image_controller.image_list);

module.exports = router;
