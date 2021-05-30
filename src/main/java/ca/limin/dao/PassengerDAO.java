package ca.limin.dao;

import ca.limin.entity.Passenger;

import java.sql.Date;
import java.util.List;

public interface PassengerDAO {
	List<Passenger> getPassengers();
	List<Passenger> getPassengersOrderByFamily();
	void savePassenger(Passenger thePassenger);
	Passenger getPassenger(int theId);
	List<Passenger> getPassengerByFamily(String family);
	List<Passenger> getPassengersByDestinationCity(String city);
	List<Passenger> getPassengersByDepartureDate(String departureDate);
	List<Passenger> getPassengersByDepartureDateAndDestinationCity(String departureDate, String city);
	void deletePassenger(int theId);
}