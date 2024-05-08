var express = require('express');
var router = express.Router();
const User = require('../models/user');
const Gallery = require('../models/gallery');
const Image = require('../models/image');

/* GET home page. */
router.get('/', async function(req, res, next) {
  try{
    const usersCount = await User.countDocuments();
    const galleriesCount = await Gallery.countDocuments();
    const imagesCount = await Image.countDocuments();
    res.render('index', { title: 'Galeria' ,user:usersCount,gallery:galleriesCount,image:imagesCount});
  }catch (err) {
    console.error(err);
    res.status(500).send('Błąd serwera');
  }
  
  

  
});

module.exports = router;
