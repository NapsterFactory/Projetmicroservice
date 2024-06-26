const express = require("express");
const blogRouter = require("./routes/BlogRoutes");
const Eureka = require('eureka-js-client').Eureka ;

const eurekaHelper = require('./eureka.helper');

const mongoose = require("mongoose");
const app = express();

const {
  DB_USER,
  DB_PASSWORD,
  DB_HOST,
  DB_PORT,
  DB_NAME,
  NODE_DOCKER_PORT
} = process.env;

mongoose.connect(`mongodb://${DB_HOST}:${DB_PORT}/${DB_NAME}`, { useNewUrlParser: true, useUnifiedTopology: true })
  .then(() => {
    console.log('Connected to the database');
  })
  .catch((error) => {
    console.error('Error connecting to the database', error);
  });

app.use(express.json());
 
app.listen(3001, () => {
  console.log(`Server is running on port 3001`);
});
// eurekaHelper.start((error)=>{if(error){console.log(error);}
// console.log('Eureka client started')})
eurekaHelper.registerWithEureka('nodejsMS', 3001);

module.exports = app;
app.use(express.json());

app.use('/api/blogs', blogRouter);

