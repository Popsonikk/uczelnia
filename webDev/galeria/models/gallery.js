const mongoose = require("mongoose");
const Schema = mongoose.Schema;
const User = require("../models/user");
const GallerySchema = new Schema({
    name: { type: String, maxLength: 100, required: true },
    description: { type: String, maxLength: 200, required: true  },
    user: { type: Schema.Types.ObjectId, ref: User,required: true }
}, { collection: 'galleries' });
// Export model
module.exports = mongoose.model("galleries" , GallerySchema);