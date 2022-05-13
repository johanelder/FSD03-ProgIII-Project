//current build for Flight search API
//API toke : b45b05fc894f28258fd9e861c0a455df
// Marker 362806
// links https://www.travelpayouts.com/developers/api
//       https://rapidapi.com/Travelpayouts/api/flight-data/details

const axios = require("axios");

const options = {
  method: 'GET',
  url: 'https://travelpayouts-travelpayouts-flight-data-v1.p.rapidapi.com/v1/prices/monthly',
  params: {origin: 'LED', destination: ' MOW', currency: 'CAD', length: '3'},
  headers: {
    'X-Access-Token': 'b45b05fc894f28258fd9e861c0a455df',
    'X-RapidAPI-Host': 'travelpayouts-travelpayouts-flight-data-v1.p.rapidapi.com',
    'X-RapidAPI-Key': '548e4ef8damshbedfdc12afb686dp16cdb2jsn018684b57954'
  }
};

axios.request(options).then(function (response) {
	console.log(response.data);
}).catch(function (error) {
	console.error(error);
});

//pricing script

const axios = require("axios");

const options = {
  method: 'GET',
  url: 'https://travelpayouts-travelpayouts-flight-data-v1.p.rapidapi.com/v2/prices/latest',
  params: {
    destination: 'LED',
    origin: 'MOW',
    period_type: 'year',
    one_way: ' ',
    show_to_affiliates: 'true',
    trip_class: '0',
    currency: 'RUB',
    page: '1',
    sorting: 'price',
    limit: '30'
  },
  headers: {
    'X-Access-Token': 'b45b05fc894f28258fd9e861c0a455df',
    'X-RapidAPI-Host': 'travelpayouts-travelpayouts-flight-data-v1.p.rapidapi.com',
    'X-RapidAPI-Key': '548e4ef8damshbedfdc12afb686dp16cdb2jsn018684b57954'
  }
};

axios.request(options).then(function (response) {
	console.log(response.data);
}).catch(function (error) {
	console.error(error);
});