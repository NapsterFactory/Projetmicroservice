require('dotenv').config();
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

mongoose.connect(`mongodb://${DB_USER}:${DB_PASSWORD}@${DB_HOST}:${DB_PORT}/${DB_NAME}`, { useNewUrlParser: true, useUnifiedTopology: true })
    .then(() => {
      console.log('Connected to the database');
    })
    .catch((error) => {
      console.error('Error connecting to the database', error);
    });

app.use(express.json());

app.listen(NODE_DOCKER_PORT, () => {
  console.log(`Server is running on port ${NODE_DOCKER_PORT}`);
});
eurekaHelper.registerWithEureka('nodejsMS', NODE_DOCKER_PORT);

module.exports = app;
app.use(express.json());

app.use('/api/blogs', blogRouter);