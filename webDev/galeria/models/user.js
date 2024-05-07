const mongoose = require("mongoose");
const Schema = mongoose.Schema;

const UserSchema = new Schema({
    imie: { type: String, maxLength: 100, required: true },
    nazwisko: { type: String, maxLength: 100, required: true },
}, { collection: 'users' }); 

// Export model
module.exports = mongoose.model("users", UserSchema);