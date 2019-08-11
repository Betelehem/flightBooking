package mum.edu.flightbooking.entity;

import mum.edu.flightbooking.dto.AirPort;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
public class Flight {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String flightNumber;
    @DateTimeFormat(pattern = "yyyy-MM-dd")//yyyy-MM-dd HH:mm:ss
    private Date startingTime;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date destinationTime;
//    @Enumerated(EnumType.STRING)
//    private ELevel level;

    @OneToOne(cascade= {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
    @JoinColumn(name="departAirPort_id", unique= true, nullable=true, insertable=true, updatable=true)
    private List<AirPortLocation> deprtureAirPort;
    @OneToOne(cascade= {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
    @JoinColumn(name="arrivalAirPort_id", unique= true, nullable=true, insertable=true, updatable=true)
    private List<AirPortLocation> arrivalAirPort;


    @OneToOne(cascade= {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
    @JoinColumn(name="airPlane_id", unique= true, nullable=true, insertable=true, updatable=true)
    private AirPlane airPlane;

    public Flight(){}

    public Flight(String flightNumber, Date startingTime, Date destinationTime,
                  List<AirPortLocation> deprtureAirPort, List<AirPortLocation> arrivalAirPort, AirPlane airPlane) {
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

//    public ELevel getLevel() {
//        return level;
//    }
//
//    public void setLevel(ELevel level) {
//        this.level = level;
//    }

    public void addDeparture(AirPortLocation airPortLocation){

    }

    public List<AirPortLocation> getDeprtureAirPort() {
        return deprtureAirPort;
    }

    public void setDeprtureAirPort(List<AirPortLocation> deprtureAirPort) {
        this.deprtureAirPort = deprtureAirPort;
    }

    public List<AirPortLocation> getArrivalAirPort() {
        return arrivalAirPort;
    }

    public void setArrivalAirPort(List<AirPortLocation> arrivalAirPort) {
        this.arrivalAirPort = arrivalAirPort;
    }

    public AirPlane getAirPlane() {
        return airPlane;
    }

    public void setAirPlane(AirPlane airPlane) {
        this.airPlane = airPlane;
    }
}
