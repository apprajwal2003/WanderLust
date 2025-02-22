const mongoose = require('mongoose')
const Schema = mongoose.Schema
const Review = require('./review.js')

const listingSchema = new Schema({
  title: {
    type: String,
    required: true
  },
  description: {
    type: String
  },
  image: {
    filename: {
      type: String,
      default: 'listing image'
    },
    url: {
      type: String,
      default:
        'https://www.istockphoto.com/photo/exterior-of-modern-home-gm169821670-26945756?utm_campaign=srp_photos_top&utm_content=https%3A%2F%2Funsplash.com%2Fs%2Fphotos%2Fhome-design-from-outside%3Flicense%3Dfree&utm_medium=affiliate&utm_source=unsplash&utm_term=home+design+from+outside%3A%3Areduced-affiliates%3Aquarter',
      set: v =>
        v === ''
          ? 'https://www.istockphoto.com/photo/exterior-of-modern-home-gm169821670-26945756?utm_campaign=srp_photos_top&utm_content=https%3A%2F%2Funsplash.com%2Fs%2Fphotos%2Fhome-design-from-outside%3Flicense%3Dfree&utm_medium=affiliate&utm_source=unsplash&utm_term=home+design+from+outside%3A%3Areduced-affiliates%3Aquarter'
          : v
    }
  },
  price: {
    type: Number
  },
  location: {
    type: String
  },
  country: {
    type: String
  },
  reviews: [
    {
      type: Schema.Types.ObjectId,
      ref: 'Review'
    }
  ],
  owner: {
    type: Schema.Types.ObjectId,
    ref: 'User'
  }
})

listingSchema.post('findOneAndDelete', async listing => {
  if (listing) {
    await Review.deleteMany({ _id: { $in: listing.reviews } })
  }
})

const Listing = mongoose.model('Listing', listingSchema)
module.exports = Listing
