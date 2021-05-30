package ca.limin.dao;

import ca.limin.entity.Passenger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PassengerDAOImpl implements PassengerDAO {
	@Autowired
	private SessionFactory sessionFactory;
			
	@Override
	public List<Passenger> getPassengers() {
		Session currentSession = sessionFactory.getCurrentSession();
		Query<Passenger> theQuery = currentSession.createQuery("from Passenger", Passenger.class);
		List<Passenger> passengers = theQuery.getResultList();
		return passengers;
	}

	@Override
	public List<Passenger> getPassengersOrderByFamily() {
		Session currentSession = sessionFactory.getCurrentSession();
		Query<Passenger> theQuery = currentSession.createQuery("from Passenger order by family", Passenger.class);
		System.out.println(theQuery.getResultList().toString());
		List<Passenger> passengers = theQuery.getResultList();
		return passengers;
	}

	@Override
	public void savePassenger(Passenger thePassenger) {
		Session currentSession = sessionFactory.getCurrentSession();
		currentSession.saveOrUpdate(thePassenger);
	}

	@Override
	public Passenger getPassenger(int theId) {
		Session currentSession = sessionFactory.getCurrentSession();
		Passenger thePassenger = currentSession.get(Passenger.class, theId);
		return thePassenger;
	}

	@Override
	public List<Passenger> getPassengerByFamily(String family) {
		Session currentSession = sessionFactory.getCurrentSession();
		String sql = "select * from passenger where family='" + family + "'";
		List<Passenger> passengers = currentSession.createSQLQuery(sql).addEntity(Passenger.class).getResultList();
		return passengers;
	}

	@Override
	public List<Passenger> getPassengersByDestinationCity(String city) {
		Session currentSession = sessionFactory.getCurrentSession();
		String sql = "select * from passenger p join passenger_flight pf on p.passenger_id=pf.passenger_id join flight f " +
				"on pf.flight_id=f.flight_id where f.to_city like '%" + city + "' group by p.family";
		List<Passenger> passengers = currentSession.createSQLQuery(sql).addEntity(Passenger.class).getResultList();
		return passengers;
	}

	@Override
	public List<Passenger> getPassengersByDepartureDate(String departureDate) {
		Session currentSession = sessionFactory.getCurrentSession();
		String sql = "select * from passenger p join passenger_flight pf on p.passenger_id=pf.passenger_id join flight f " +
				"on pf.flight_id=f.flight_id where f.departure_date='" + departureDate + "'";
		List<Passenger> passengers = currentSession.createSQLQuery(sql).addEntity(Passenger.class).getResultList();
		return passengers;
	}

	@Override
	public List<Passenger> getPassengersByDepartureDateAndDestinationCity(String departureDate, String city) {
		Session currentSession = sessionFactory.getCurrentSession();
		String sql = "select * from passenger p join passenger_flight pf on p.passenger_id=pf.passenger_id join flight f " +
				"on pf.flight_id=f.flight_id where f.departure_date='" + departureDate + "' and f.to_city='" + city + "'";
		List<Passenger> passengers = currentSession.createSQLQuery(sql).addEntity(Passenger.class).getResultList();
		return passengers;
	}

	@Override
	public void deletePassenger(int theId) {
		Session currentSession = sessionFactory.getCurrentSession();
		Query theQuery = 
				currentSession.createQuery("delete from Passenger where passengerId=:passengerId");
		theQuery.setParameter("passengerId", theId);
		theQuery.executeUpdate();		
	}
	//..........................................................
}