package ca.limin.service;

import ca.limin.entity.Flight;

import java.util.List;

public interface FlightService {
    List<Flight> getFlights();
    void saveFlight(Flight flight);
    Flight getFlight(int theId);
}
