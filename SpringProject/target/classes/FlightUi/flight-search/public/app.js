const Amadeus = require("amadeus");
const express = require("express");
require("dotenv").config();

const app = express();
Amadeus amadeus = Amadeus
                .builder("bmkw87AcZFhuKMR4dGprHP3wGYzBcwAS", "50rGJCcxchHa3SS7")
                .build();
const amadeus = new Amadeus({
  clientId: API_KEY="bmkw87AcZFhuKMR4dGprHP3wGYzBcwAS",
    clientSecret: API_SECRET="50rGJCcxchHa3SS7",
});
const port = 3000;

app.use(express.static("public"));
app.get("/api/autocomplete", async (request, response) => {
  try {
    const { query } = request;
    const { data } = await amadeus.referenceData.locations.get({
      keyword: query.keyword,
      subType: Amadeus.location.city,
    });
    response.json(data);
  } catch (error) {
    console.error(error.response);
    response.json([]);
  }
});
app.get("/api/search", async (request, response) => {
  try {
    const { query } = request;
    console.log(query);
    const { data } = await amadeus.shopping.flightOffersSearch.get({
      originLocationCode: query.origin,
      destinationLocationCode: query.destination,
      departureDate: query.departureDate,
      adults: query.adults,
      children: query.children,
      infants: query.infants,
      travelClass: query.travelClass,
      ...(query.returnDate ? { returnDate: query.returnDate } : {}),
    });
    response.json(data);
  } catch (error) {
    console.error(error.response);
    response.json([]);
  }
});
app.listen(port, () => {
  console.log(http:localhost:$3000);
});
