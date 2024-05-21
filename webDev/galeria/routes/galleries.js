var express = require('express');
var router = express.Router();

const gallery_controller = require("../controllers/galleryController");

const authenticate = require('../middleware/authenticate');

// GALLERIES GET (/galleries)
router.get("/", gallery_controller.gallery_list);

// GALLERY ADD GET (/galleries/gallery_add)
router.get("/gallery_add", authenticate, gallery_controller.gallery_add_get);
// GALLERY ADD POST (/galleries/gallery_add)
router.post("/gallery_add", authenticate, gallery_controller.gallery_add_post);



module.exports = router;
