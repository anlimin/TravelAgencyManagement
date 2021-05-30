package ca.limin.service;

import ca.limin.dao.PassengerDAO;
import ca.limin.entity.Passenger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PassengerServiceImpl implements PassengerService {
	@Autowired
	private PassengerDAO passengerDAO;
	
	@Override
	@Transactional
	public List<Passenger> getPassengers() {
		return passengerDAO.getPassengers();
	}

	@Override
	@Transactional
	public List<Passenger> getPassengersOrderByFamily() {
		return passengerDAO.getPassengersOrderByFamily();
	}

	@Override
	@Transactional
	public void savePassenger(Passenger thePassenger) {
		passengerDAO.savePassenger(thePassenger);
	}

	@Override
	@Transactional
	public Passenger getPassenger(int theId) {
		return passengerDAO.getPassenger(theId);
	}

	@Override
	@Transactional
	public List<Passenger> getPassengerByFamily(String family) {
		return passengerDAO.getPassengerByFamily(family);
	}

	@Override
	@Transactional
	public List<Passenger> getPassengersByDestinationCity(String city) {
		return passengerDAO.getPassengersByDestinationCity(city);
	}

	@Override
	@Transactional
	public List<Passenger> getPassengersByDepartureDate(String departureDate) {
		return passengerDAO.getPassengersByDepartureDate(departureDate);
	}

	@Override
	@Transactional
	public List<Passenger> getPassengersByDepartureDateAndDestinationCity(String departureDate, String city) {
		return passengerDAO.getPassengersByDepartureDateAndDestinationCity(departureDate, city);
	}

	@Override
	@Transactional
	public void deletePassenger(int theId) {
		passengerDAO.deletePassenger(theId);
	}
}