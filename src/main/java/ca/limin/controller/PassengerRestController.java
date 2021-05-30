package ca.limin.controller;

import ca.limin.entity.Address;
import ca.limin.entity.Flight;
import ca.limin.entity.Passenger;
import ca.limin.exception.PassengerNotFoundException;
import ca.limin.service.AddressService;
import ca.limin.service.FlightService;
import ca.limin.service.PassengerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/api")
public class PassengerRestController {
	@Autowired
	private PassengerService passengerService;
	@Autowired
	private AddressService addressService;

	@Autowired
	private FlightService flightService;
	@GetMapping("/passengers")
	public List<Passenger> getPassengers() {
		return passengerService.getPassengers();
	}

	@GetMapping("/passengers/sorted/family")
	public List<Passenger> getPassengersOrderByFamily() {
		return passengerService.getPassengersOrderByFamily();
	}

	@GetMapping("/passengers/{passengerId}")
	public Passenger getPassenger(@PathVariable int passengerId) {
		Passenger thePassenger = passengerService.getPassenger(passengerId);
		if (thePassenger == null) {
			throw new PassengerNotFoundException("Passenger id not found - " + passengerId);
		}
		return thePassenger;
	}

	@GetMapping("/passengers/find/{family}")
	public List<Passenger> getPassenger(@PathVariable String family) {
		List<Passenger> thePassengers = passengerService.getPassengerByFamily(family);
		if (thePassengers.isEmpty()) {
			throw new PassengerNotFoundException("Passenger family not found - " + family);
		}
		return thePassengers;
	}

	@GetMapping("/passengers/city/{city}")
	public List<Passenger> getPassengers(@PathVariable String city) {
		List<Passenger> thePassengers = passengerService.getPassengersByDestinationCity(city);
		if (thePassengers.isEmpty()) {
			throw new PassengerNotFoundException("The destination city not found - " + city);
		}
		return thePassengers;
	}

	@GetMapping("/passengers/departuredate/{departureDate}")
	public List<Passenger> getPassengersByDepartureDate(@PathVariable String departureDate) {
		List<Passenger> thePassengers = passengerService.getPassengersByDepartureDate(departureDate);

		if (thePassengers.isEmpty()) {
			throw new PassengerNotFoundException("Departure Date not found - " + departureDate);
		}
		return thePassengers;
	}

	@GetMapping("/passengers/find/departuredate/{departureDate}/city/{city}")
	public List<Passenger> getPassengersByDepartureDateAndDestinationCity(@PathVariable String departureDate,
																		  @PathVariable String city) {
		List<Passenger> thePassengers = passengerService.getPassengersByDepartureDateAndDestinationCity(departureDate, city);

		if (thePassengers.isEmpty()) {
			throw new PassengerNotFoundException("Departure date " + departureDate + " and destination city " + city + " not found");
		}
		return thePassengers;
	}

	@PostMapping("/passengers")
	public Passenger addPassenger(@RequestBody Passenger thePassenger) {
		thePassenger.setPassengerId(0);
		thePassenger.getAddress().setAddressId(0);
		for(Flight flight : thePassenger.getFlights())
			flight.setFlightId(0);
		passengerService.savePassenger(thePassenger);
		return thePassenger;
	}

	@PutMapping("/passengers")
	public Passenger updatePassenger(@RequestBody Passenger thePassenger) {
		passengerService.savePassenger(thePassenger);
		return thePassenger;
	}

	@DeleteMapping("/passengers/{passengerId}")
	public String deletePassenger(@PathVariable int passengerId) {
		Passenger tempPassenger = passengerService.getPassenger(passengerId);
		if (tempPassenger == null) {
			throw new PassengerNotFoundException("Passenger id not found - " + passengerId);
		}
		passengerService.deletePassenger(passengerId);
		return "Deleted passenger id - " + passengerId;
	}	
}