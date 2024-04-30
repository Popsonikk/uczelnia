const mongoose = require("mongoose");
const Schema = mongoose.Schema;

const UserSchema = new Schema({
    imie: { type: String, maxLength: 100, required: true },
    nazwisko: { type: String, maxLength: 100, required: true },
}, { collection: 'Users' }); 

// Export model
module.exports = mongoose.model("Users", UserSchema);