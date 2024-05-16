var express = require('express');
var router = express.Router();

const gallery_controller = require("../controllers/galleryController");
router.get("/", gallery_controller.gallery_list);

router.get("/gallery_add", gallery_controller.gallery_add_get);
router.post("/gallery_add", gallery_controller.gallery_add_post);


module.exports = router;