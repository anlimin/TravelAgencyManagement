package ca.limin.service;

import ca.limin.dao.FlightDAO;
import ca.limin.entity.Flight;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class FlightServiceImpl implements FlightService{
    @Autowired
    private FlightDAO flightDAO;

    @Override
    @Transactional
    public List<Flight> getFlights() {
        return flightDAO.getFlights();
    }

    @Override
    @Transactional
    public Flight getFlight(int theId) {
        return flightDAO.getFlight(theId);
    }

    @Override
    @Transactional
    public void saveFlight(Flight theFlight) {
        flightDAO.saveFlight(theFlight);
    }
}
