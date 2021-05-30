package ca.limin.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name="address")
public class Address {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="address_id")
    private int addressId;

    @Column(name="number")
    private int number;

    @Column(name="street")
    private String street;

    @Column(name="city")
    private String city;

    @Column(name="state")
    private String state;

    @Column(name="country")
    private String country;

    @Column(name="postcode")
    private String postcode;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "address", targetEntity = Passenger.class)
    @JsonIgnore
    private Set<Passenger> passengers = new HashSet<>();

    public Address() {
    }

    public Address(int number, String street, String city, String state, String country, String postcode) {
        this.number = number;
        this.street = street;
        this.city = city;
        this.state = state;
        this.country = country;
        this.postcode = postcode;
    }

    public Address(int number, String street, String city, String state, String country,
                   String postcode, Set<Passenger> passengers) {
        this.number = number;
        this.street = street;
        this.city = city;
        this.state = state;
        this.country = country;
        this.postcode = postcode;
        this.passengers = passengers;
    }

    public int getAddressId() {
        return addressId;
    }

    public void setAddressId(int addressId) {
        this.addressId = addressId;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public Set<Passenger> getPassengers() {
        return passengers;
    }

    public void setPassengers(Set<Passenger> passengers) {
        this.passengers = passengers;
    }

    @Override
    public String toString() {
        return "Address{" +
                "addressId=" + addressId +
                ", number=" + number +
                ", street='" + street + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", country='" + country + '\'' +
                ", postcode='" + postcode + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Address address = (Address) o;
        return  number == address.number &&
                street.equals(address.street) &&
                postcode.equals(address.postcode);
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + number;
        result = 31 * result + (street == null ? 0 : street.hashCode());
        result = 31 * result + (postcode == null ? 0 : postcode.hashCode());
        return result;
    }
}
