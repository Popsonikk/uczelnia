var express = require('express');
var router = express.Router();

// Middleware autentykacji
const authenticate = require('../middleware/authenticate');

const gallery_controller = require("../controllers/galleryController");
router.get("/", gallery_controller.gallery_list);

router.get("/gallery_add", authenticate, gallery_controller.gallery_add_get);
// GALLERY ADD POST (/galleries/gallery_add)
router.post("/gallery_add", authenticate, gallery_controller.gallery_add_post);


module.exports = router;