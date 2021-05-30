package ca.limin.entity;

public class AllObjects {
    private Passenger passenger;
    private Address address;
    private Flight flight;

    public AllObjects() {
    }

    public AllObjects(Passenger passenger, Address address, Flight flight) {
        this.passenger = passenger;
        this.address = address;
        this.flight = flight;
    }

    public Passenger getPassenger() {
        return passenger;
    }

    public void setPassenger(Passenger passenger) {
        this.passenger = passenger;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Flight getFlight() {
        return flight;
    }

    public void setFlight(Flight flight) {
        this.flight = flight;
    }
}
