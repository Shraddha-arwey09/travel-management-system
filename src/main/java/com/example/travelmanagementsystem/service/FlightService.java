package com.example.travelmanagementsystem.service;

import com.example.travelmanagementsystem.repository.FlightRepository;
import org.springframework.stereotype.Service;
import com.example.travelmanagementsystem.entity.Flight;
import java.util.List;


@Service
public class FlightService {
    private final FlightRepository flightRepository;

    public FlightService(FlightRepository flightRepository) {
        this.flightRepository = flightRepository;
    }
    public List<Flight> getAllFlights() {
        return flightRepository.findAll();
    }
    public Flight saveFlight(Flight flight) {
        return flightRepository.save(flight);
    }
    public Flight getFlightById(Long id) {
        return flightRepository.findById(id).orElse(null);
    }

    public Flight updateFlight(Long id, Flight updatedFlight) {

        Flight existingFlight = flightRepository.findById(id).orElse(null);

        if (existingFlight != null) {

            existingFlight.setFlightNumber(updatedFlight.getFlightNumber());
            existingFlight.setAirlineName(updatedFlight.getAirlineName());
            existingFlight.setSource(updatedFlight.getSource());
            existingFlight.setDestination(updatedFlight.getDestination());
            existingFlight.setDepartureTime(updatedFlight.getDepartureTime());
            existingFlight.setArrivalTime(updatedFlight.getArrivalTime());
            existingFlight.setPrice(updatedFlight.getPrice());
            existingFlight.setAvailableSeats(updatedFlight.getAvailableSeats());

            return flightRepository.save(existingFlight);
        }

        return null;
    }
    public void deleteFlight(Long id) {
        flightRepository.deleteById(id);
    }


}