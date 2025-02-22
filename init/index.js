const mongoose = require('mongoose')
const initData = require('./data.js')
const Listing = require('../models/listing.js')

const MONGO_URL = 'mongodb://127.0.0.1:27017/wanderlust'

main()
  .then(() => {
    console.log('Connection successfull')
  })
  .catch(err => {
    console.log(err)
  })

async function main () {
  await mongoose.connect(MONGO_URL)
}

const initDB = async () => {
  await Listing.deleteMany({})
  initData.data = initData.data.map(obj => ({
    ...obj,
    owner: '67b87df429bc00b920dc7c66'
  }))
  await Listing.insertMany(initData.data)
  console.log('Data was initialised')
}

initDB()
