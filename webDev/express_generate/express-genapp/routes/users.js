var express = require('express');
var router = express.Router();

/* GET users listing. */
router.get('/', function(req, res, next) {
  res.send('respond with a resource');
});


router.get('/newuser', function(req, res, next) {
  res.send('This is a new user');
});

module.exports = router;
