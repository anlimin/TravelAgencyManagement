package ca.limin.dao;

import ca.limin.entity.Flight;

import java.util.List;

public interface FlightDAO {
    List<Flight> getFlights();
    void saveFlight(Flight flight);
    Flight getFlight(int theId);
}
