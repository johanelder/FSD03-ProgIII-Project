package com.example.SpringProject.controller;

import com.amadeus.exceptions.ResponseException;
import com.amadeus.resources.*;
import com.example.SpringProject.Database.DatabaseConnect;
import com.example.SpringProject.entity.AmadeusConnect;
import com.google.gson.JsonObject;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping(value="/api")
public class ApiController {
    @GetMapping("/locations")
    public Location[] locations(@RequestParam(required=true) String keyword) throws ResponseException {
        return AmadeusConnect.INSTANCE.location(keyword);
    }
    @GetMapping("/flights")
    public FlightOfferSearch[] flights(@RequestParam(required=true) String origin,
                                       @RequestParam(required=true) String destination,
                                       @RequestParam(required=true) String departDate,
                                       @RequestParam(required=true) String adults,
                                       @RequestParam(required = false) String returnDate)
            throws ResponseException {
        return AmadeusConnect.INSTANCE.flights(origin, destination, departDate, adults, returnDate);
    }
    @PostMapping("/confirm")
    public FlightPrice confirm(@RequestBody(required=true) FlightOfferSearch search) throws ResponseException {
        return AmadeusConnect.INSTANCE.confirm(search);
    }
    @PostMapping("/traveler")
    public Traveler traveler(@RequestBody(required=true) JsonObject travelerInfo) {
        return DatabaseConnect.traveler(travelerInfo.get("data").getAsJsonObject());
    }
    @PostMapping("/order")
    public FlightOrder order(@RequestBody(required=true) JsonObject order) throws ResponseException{
        return AmadeusConnect.INSTANCE.order(order);
    }
}





