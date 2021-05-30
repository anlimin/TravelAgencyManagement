package ca.limin.controller;

import ca.limin.entity.Address;
import ca.limin.entity.AllObjects;
import ca.limin.entity.Flight;
import ca.limin.entity.Passenger;
import ca.limin.exception.PassengerNotFoundException;
import ca.limin.service.AddressService;
import ca.limin.service.FlightService;
import ca.limin.service.PassengerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Controller
@RequestMapping("/passenger")
public class PassengerController {
	@Autowired
	private PassengerService passengerService;

	@Autowired
	private AddressService addressService;

	@Autowired
	private FlightService flightService;
	
	@GetMapping("/list")
	public String listPassengers(Model theModel) {
		List<Passenger> thePassengers = passengerService.getPassengers();
		theModel.addAttribute("passengers", thePassengers);
		return "list-passengers";
	}

	@GetMapping("/sorted/family")
	public String getPassengersOrderByFamily(Model theModel) {
		List<Passenger> thePassengers = passengerService.getPassengersOrderByFamily();
		theModel.addAttribute("passengers", thePassengers);
		return "list-passengers";
	}

	@GetMapping("/{passengerId}")
	public String getPassenger(@PathVariable int passengerId, Model theModel) {
		Passenger thePassenger = passengerService.getPassenger(passengerId);
		List<Passenger> thePassengers = new ArrayList<>();
		if (thePassenger == null) {
			throw new PassengerNotFoundException("Passenger id not found - " + passengerId);
		}
		thePassengers.add(thePassenger);
		theModel.addAttribute("passengers", thePassengers);
		return "list-passengers";
	}

	@GetMapping("/find/{family}")
	public String getPassenger(@PathVariable String family, Model theModel) {
		List<Passenger> thePassengers = passengerService.getPassengerByFamily(family);
		if (thePassengers.isEmpty()) {
			throw new PassengerNotFoundException("Passenger family not found - " + family);
		}
		theModel.addAttribute("passengers", thePassengers);
		return "list-passengers";
	}

	@GetMapping("/city/{city}")
	public String getPassengers(@PathVariable String city, Model theModel) {
		List<Passenger> thePassengers = passengerService.getPassengersByDestinationCity(city);
		System.out.println(thePassengers.toString());
		if (thePassengers.isEmpty()) {
			throw new PassengerNotFoundException("The destination city not found - " + city);
		}
		theModel.addAttribute("passengers", thePassengers);
		return "list-passengers";
	}

	@GetMapping("/departuredate/{departureDate}")
	public String getPassengersByDepartureDate(@PathVariable String departureDate, Model theModel) {
		List<Passenger> thePassengers = passengerService.getPassengersByDepartureDate(departureDate);
		if (thePassengers.isEmpty()) {
			throw new PassengerNotFoundException("Departure Date not found - " + departureDate);
		}
		theModel.addAttribute("passengers", thePassengers);
		return "list-passengers";
	}

	@GetMapping("/find/departuredate/{departureDate}/city/{city}")
	public String getPassengersByDepartureDateAndDestinationCity(@PathVariable String departureDate,
																		  @PathVariable String city, Model theModel) {
		List<Passenger> thePassengers = passengerService.getPassengersByDepartureDateAndDestinationCity(departureDate, city);
		if (thePassengers.isEmpty()) {
			throw new PassengerNotFoundException("Departure date " + departureDate + " and destination city " + city + " not found");
		}
		theModel.addAttribute("passengers", thePassengers);
		return "list-passengers";
	}

	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel) {
		AllObjects allObjects = new AllObjects();
		theModel.addAttribute("allObjects", allObjects);
		return "passenger-form";
	}

	@PostMapping("/savePassenger")
	public String savePassenger(@ModelAttribute("allObjects") AllObjects allObjects) {
		Passenger thePassenger = allObjects.getPassenger();
		Address theAddress = allObjects.getAddress();
		Flight theFlight = allObjects.getFlight();
		Set<Flight> flightSet = new HashSet<>();
		Set<Passenger> passengerSet = new HashSet<>();
		if(isNewAddress(theAddress))
			addressService.saveAddress(theAddress);
		flightService.saveFlight(theFlight);
		flightSet.add(theFlight);
		passengerSet.add(thePassenger);
		theFlight.setPassengers(passengerSet);
		thePassenger.setFlights(flightSet);
		thePassenger.setAddress(theAddress);
		passengerService.savePassenger(thePassenger);
		return "redirect:/passenger/list";
	}
	
	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("passengerId") int theId, Model theModel) {
		Passenger thePassenger = passengerService.getPassenger(theId);
		Address theAddress = thePassenger.getAddress();
		AllObjects allObjects = new AllObjects();
		allObjects.setPassenger(thePassenger);
		allObjects.setAddress(theAddress);
		theModel.addAttribute("allObjects", allObjects);
		return "passenger-form";
	}

	@GetMapping("/showFormForFlight")
	public String showFormForFlight(@RequestParam("passengerId") int theId, Model theModel) {
		Passenger thePassenger = passengerService.getPassenger(theId);
		theModel.addAttribute("flights", thePassenger.getFlights());
		return "flight-form";
	}

	@GetMapping("/delete")
	public String deletePassenger(@RequestParam("passengerId") int theId) {
		passengerService.deletePassenger(theId);
		return "redirect:/passenger/list";
	}

	private boolean isNewAddress(Address theAddress){
		List<Address> theAddresses = addressService.getAddresses();
		boolean flag = true;
		for(Address address : theAddresses){
			if(address.equals(theAddress)){
				flag = false;
				theAddress.setAddressId(address.getAddressId());
				theAddress.setNumber(address.getNumber());
				theAddress.setStreet(address.getStreet());
				theAddress.setCity(address.getCity());
				theAddress.setState(address.getState());
				theAddress.setCountry(address.getCountry());
				theAddress.setPostcode(address.getPostcode());
				break;
			}
		}
		return flag;
	}
}