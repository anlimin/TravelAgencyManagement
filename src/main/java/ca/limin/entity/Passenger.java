package ca.limin.entity;

import com.fasterxml.jackson.annotation.*;

import javax.persistence.*;
import java.sql.Date;
import java.util.LinkedHashMap;
import java.util.Set;

@Entity
@Table(name="passenger")
public class Passenger {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="passenger_id")
    private int passengerId;

    @Column(name="name")
    private String name;

    @Column(name="family")
    private String family;

    @Column(name="birthdate")
    private Date birthdate;

    @Column(name="email")
    private String email;

    @Column(name="phone")
    private String phone;

    @Column(name="gender")
    private String gender;

    @Column(name="payment")
    private String payment;

    @Transient
    private LinkedHashMap<String, String> paymentOptions;

    @ManyToOne(cascade = CascadeType.ALL, targetEntity=Address.class)
    @JoinColumn(name = "address_id", updatable = false, nullable=false)
    @JsonIgnoreProperties(value="passengers")
    private Address address;

    @ManyToMany(cascade = CascadeType.ALL, mappedBy = "passengers", fetch = FetchType.EAGER)
    @JsonIgnoreProperties(value="passengers")
    private Set<Flight> flights;

    public Passenger() {
        populateMyHashMap();
    }

    public Passenger(String name, String family, Date birthdate, String email, String phone, String gender,
                     String payment, Address address) {
        this.name = name;
        this.family = family;
        this.birthdate = birthdate;
        this.email = email;
        this.phone = phone;
        this.gender = gender;
        this.address = address;
        this.payment = payment;
    }

    public Passenger(String name, String family, Date birthdate, String email, String phone, String gender,
                     String payment, Address address, Set<Flight> flights) {
        this.name = name;
        this.family = family;
        this.birthdate = birthdate;
        this.email = email;
        this.phone = phone;
        this.gender = gender;
        this.payment = payment;
        this.address = address;
        this.flights = flights;
    }

    public int getPassengerId() {
        return passengerId;
    }

    public void setPassengerId(int passengerId) {
        this.passengerId = passengerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFamily() {
        return family;
    }

    public void setFamily(String family) {
        this.family = family;
    }

    @JsonFormat(pattern="yyyy-MM-dd")
    public Date getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPayment() {
        return payment;
    }

    public void setPayment(String payment) {
        this.payment = payment;
    }

    public LinkedHashMap<String, String> getPaymentOptions() {
        return paymentOptions;
    }

    public void setPaymentOptions(LinkedHashMap<String, String> paymentOptions) {
        this.paymentOptions = paymentOptions;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Set<Flight> getFlights() {
        return flights;
    }

    public void setFlights(Set<Flight> flights) {
        this.flights = flights;
    }

    @Override
    public String toString() {
        return "Passenger{" +
                "passengerId=" + passengerId +
                ", name='" + name + '\'' +
                ", family='" + family + '\'' +
                ", birthdate=" + birthdate +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", gender='" + gender + '\'' +
                ", payment='" + payment + '\'' +
                ", address=" + address +
                '}';
    }

    private void populateMyHashMap() {
        paymentOptions = new LinkedHashMap<>();
        paymentOptions.put("Master", "Master");
        paymentOptions.put("Visa", "Visa");
        paymentOptions.put("Paypal", "Paypal");
        paymentOptions.put("Debit", "Debit");
    }
}
