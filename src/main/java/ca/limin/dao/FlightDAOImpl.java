package ca.limin.dao;

import ca.limin.entity.Address;
import ca.limin.entity.Flight;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class FlightDAOImpl implements FlightDAO{
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Flight> getFlights() {
        Session currentSession = sessionFactory.getCurrentSession();
        Query<Flight> theQuery = currentSession.createQuery("from Flight ", Flight.class);
        List<Flight> flights = theQuery.getResultList();
        return flights;
    }

    @Override
    public Flight getFlight(int theId) {
        Session currentSession = sessionFactory.getCurrentSession();
        Flight theFlight = currentSession.get(Flight.class, theId);
        return theFlight;
    }

    @Override
    public void saveFlight(Flight theFlight) {
        Session currentSession = sessionFactory.getCurrentSession();
        currentSession.saveOrUpdate(theFlight);
    }
}
