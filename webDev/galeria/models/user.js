const mongoose = require("mongoose");
const { collection } = require("./gallery");

const Schema = mongoose.Schema;

const UserSchema = new Schema({
  first_name: { type: String, maxLength: 100 },
  last_name: { type: String, maxLength: 100 },
  username: { type: String, maxLength: 100 },
  password: {type: String},
}, { collection: 'users' });

// Export model
module.exports = mongoose.model("User", UserSchema);
