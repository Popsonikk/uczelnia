const mongoose = require("mongoose");
const Schema = mongoose.Schema;

const UserSchema = new Schema({
    first_name: { type: String, maxLength: 100, required: true },
    last_name: { type: String, maxLength: 100, required: true },
    username: { type: String, maxLength: 100, required: true },
}, { collection: 'users' }); 

// Export model
module.exports = mongoose.model("users", UserSchema);