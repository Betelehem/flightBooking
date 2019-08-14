package mum.edu.flightbooking.entity;

import mum.edu.flightbooking.dto.AirPort;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Flight {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String flightNumber;
    private Double basicPrice;
    private Double mainPrice;

    @DateTimeFormat(pattern = "yyyy-MM-dd")//yyyy-MM-dd HH:mm:ss
    private Date startingTime;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date destinationTime;
//    @Enumerated(EnumType.STRING)
//    private ELevel level;

    @OneToOne(cascade= {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
    @JoinColumn(name="departAirPort_id",  nullable=true, insertable=true, updatable=true)
    private AirPortLocation deprtureAirPort;
    @OneToOne(cascade= {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
    @JoinColumn(name="arrivalAirPort_id",  nullable=true, insertable=true, updatable=true)
    private AirPortLocation arrivalAirPort;
    @OneToOne(cascade= {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
    @JoinColumn(name="airPlane_id",  nullable=true, insertable=true, updatable=true)
    private AirPlane airPlane;

    public Flight(){}

    public Flight(String flightNumber, Date startingTime, Date destinationTime,
                  AirPortLocation deprtureAirPort, AirPortLocation arrivalAirPort, AirPlane airPlane) {
        this.flightNumber = flightNumber;
        this.startingTime = startingTime;
        this.destinationTime = destinationTime;

        this.deprtureAirPort = deprtureAirPort;
        this.arrivalAirPort = arrivalAirPort;
        this.airPlane = airPlane;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(String flightNumber) {
        this.flightNumber = flightNumber;
    }

    public Date getStartingTime() {
        return startingTime;
    }

    public void setStartingTime(Date startingTime) {
        this.startingTime = startingTime;
    }

    public Date getDestinationTime() {
        return destinationTime;
    }

    public void setDestinationTime(Date destinationTime) {
        this.destinationTime = destinationTime;
    }

    public Double getBasicPrice() {
        return basicPrice;
    }

    public void setBasicPrice(Double basicPrice) {
        this.basicPrice = basicPrice;
    }

    public Double getMainPrice() {
        return mainPrice;
    }

    public void setMainPrice(Double mainPrice) {
        this.mainPrice = mainPrice;
    }
    //    public ELevel getLevel() {
//        return level;
//    }
//
//    public void setLevel(ELevel level) {
//        this.level = level;
//    }

    public AirPortLocation getDeprtureAirPort() {
        return deprtureAirPort;
    }

    public void setDeprtureAirPort(AirPortLocation deprtureAirPort) {
        this.deprtureAirPort = deprtureAirPort;
    }

    public AirPortLocation getArrivalAirPort() {
        return arrivalAirPort;
    }

    public void setArrivalAirPort(AirPortLocation arrivalAirPort) {
        this.arrivalAirPort = arrivalAirPort;
    }

    public AirPlane getAirPlane() {
        return airPlane;
    }

    public void setAirPlane(AirPlane airPlane) {
        this.airPlane = airPlane;
    }
}
