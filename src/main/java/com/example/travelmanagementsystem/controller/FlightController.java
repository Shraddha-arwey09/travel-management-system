
package com.example.travelmanagementsystem.controller;

import com.example.travelmanagementsystem.entity.Flight;
import com.example.travelmanagementsystem.service.FlightService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/flights")
public class FlightController {

    private final FlightService flightService;

    public FlightController(FlightService flightService) {
        this.flightService = flightService;
    }

    // Get all flights
    @GetMapping
    public List<Flight> getAllFlights() {
        return flightService.getAllFlights();
    }

    // Add a new flight
    @PostMapping
    public Flight saveFlight(@RequestBody Flight flight) {
        return flightService.saveFlight(flight);
    }

    // Get flight by ID
    @GetMapping("/{id}")
    public Flight getFlightById(@PathVariable Long id) {
        return flightService.getFlightById(id);
    }

    @PutMapping("/{id}")
    public Flight updateFlight(
            @PathVariable Long id,
            @RequestBody Flight flight) {

        return flightService.updateFlight(id, flight);
    }
    @DeleteMapping("/{id}")
    public String deleteFlight(@PathVariable Long id) {

        flightService.deleteFlight(id);

        return "Flight deleted successfully!";
    }
}
