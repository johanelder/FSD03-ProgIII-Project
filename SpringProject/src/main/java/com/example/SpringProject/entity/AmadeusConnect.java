package com.example.SpringProject.entity;
import com.amadeus.Amadeus;
import com.amadeus.Params;
import com.amadeus.referenceData.Locations;
import com.amadeus.resources.FlightOfferSearch;
import com.amadeus.resources.FlightOrder;
import com.amadeus.resources.FlightPrice;
import com.amadeus.resources.Location;
import com.amadeus.exceptions.ResponseException;
import com.google.gson.JsonObject;

public enum AmadeusConnect {
    INSTANCE;
    private Amadeus amadeus;
    AmadeusConnect() {
        this.amadeus = Amadeus
                .builder("bmkw87AcZFhuKMR4dGprHP3wGYzBcwAS", "50rGJCcxchHa3SS7")
                .build();
    }
    public Location[] location(String keyword) throws ResponseException {
        return amadeus.referenceData.locations.get(Params
                .with("keyword", keyword)
                .and("subType", Locations.AIRPORT));
    }
    public FlightOfferSearch[] flights(String origin, String destination, String departDate, String adults, String returnDate) throws ResponseException {
        return amadeus.shopping.flightOffersSearch.get(
                Params.with("originLocationCode", origin)
                        .and("destinationLocationCode", destination)
                        .and("departureDate", departDate)
                        .and("returnDate", returnDate)
                        .and("adults", adults)
                        .and("max", 25));
    }
    public FlightPrice confirm(FlightOfferSearch offer) throws ResponseException {
        return amadeus.shopping.flightOffersSearch.pricing.post(offer);
    }
    public FlightOrder order(JsonObject order) throws ResponseException {
        return amadeus.booking.flightOrders.post(order);
    }

}
