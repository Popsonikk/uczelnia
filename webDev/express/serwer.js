const express = require('express');
const morgan = require('morgan');
const path = require('path');

const app = express();


app.use('/images', express.static(path.join(__dirname, 'public', 'images')));
app.use('/pictures', express.static(path.join(__dirname, 'public', 'pictures')));
app.use('/multimedia', express.static(path.join(__dirname, 'public', 'multimedia')));


app.set('view engine', 'pug');
app.set('views', path.join(__dirname, 'views'));


app.use(morgan('dev'));


app.get('/', (req, res) => {
    res.render('index');
});


const PORT = 3000;
app.listen(PORT, () => {
    console.log(`Serwer uruchomiony na http://localhost:${PORT}`);
});