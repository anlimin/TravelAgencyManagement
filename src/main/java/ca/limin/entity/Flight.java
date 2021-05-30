package ca.limin.entity;

import com.fasterxml.jackson.annotation.*;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Time;
import java.util.Set;

@Entity
@Table(name="flight")
public class Flight {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="flight_id")
    private int flightId;

    @Column(name="from_city")
    private String fromCity;

    @Column(name="departure_date")
    private Date departureDate;

    @Column(name="departure_time")
    private Time departureTime;

    @Column(name="to_city")
    private String toCity;

    @Column(name="destination_date")
    private Date destinationDate;

    @Column(name="destination_time")
    private Time destinationTime;

    @ManyToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JsonIgnoreProperties(value="flights")
    @JoinTable(name = "passenger_flight",
            joinColumns = {@JoinColumn(name = "flight_id", updatable = false, nullable=false)},
            inverseJoinColumns = {@JoinColumn(name = "passenger_id", updatable = false, nullable=false)}
    )
    private Set<Passenger> passengers;

    public Flight() {
    }

    public Flight(String fromCity, Date departureDate, Time departureTime, String toCity, Date destinationDate,
                  Time destinationTime) {
        this.fromCity = fromCity;
        this.departureDate = departureDate;
        this.departureTime = departureTime;
        this.toCity = toCity;
        this.destinationDate = destinationDate;
        this.destinationTime = destinationTime;
    }

    public Flight(String fromCity, Date departureDate, Time departureTime, String toCity, Date destinationDate,
                  Time destinationTime, Set<Passenger> passengers) {
        this.fromCity = fromCity;
        this.departureDate = departureDate;
        this.departureTime = departureTime;
        this.toCity = toCity;
        this.destinationDate = destinationDate;
        this.destinationTime = destinationTime;
        this.passengers = passengers;
    }

    public int getFlightId() {
        return flightId;
    }

    public void setFlightId(int flightId) {
        this.flightId = flightId;
    }

    public String getFromCity() {
        return fromCity;
    }

    public void setFromCity(String fromCity) {
        this.fromCity = fromCity;
    }

    @JsonFormat(pattern="yyyy-MM-dd")
    public Date getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(Date departureDate) {
        this.departureDate = departureDate;
    }

    @JsonFormat(pattern="HH:mm:ss")
    public Time getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(Time departureTime) {
        this.departureTime = departureTime;
    }

    public String getToCity() {
        return toCity;
    }

    public void setToCity(String toCity) {
        this.toCity = toCity;
    }

    @JsonFormat(pattern="yyyy-MM-dd")
    public Date getDestinationDate() {
        return destinationDate;
    }

    public void setDestinationDate(Date destinationDate) {
        this.destinationDate = destinationDate;
    }

    @JsonFormat(pattern="HH:mm:ss")
    public Time getDestinationTime() {
        return destinationTime;
    }

    public void setDestinationTime(Time destinationTime) {
        this.destinationTime = destinationTime;
    }

    public Set<Passenger> getPassengers() {
        return passengers;
    }

    public void setPassengers(Set<Passenger> passengers) {
        this.passengers = passengers;
    }

    @Override
    public String toString() {
        return "Flight{" +
                "flightId=" + flightId +
                ", fromCity='" + fromCity + '\'' +
                ", departureDate=" + departureDate +
                ", departureTime=" + departureTime +
                ", toCity='" + toCity + '\'' +
                ", destinationDate=" + destinationDate +
                ", destinationTime=" + destinationTime +
                '}';
    }
}
