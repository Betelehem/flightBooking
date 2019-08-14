package mum.edu.flightbooking.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class AirPort {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String city;
    private String state;
    private String nickName;

    public AirPort(){}

    public AirPort(String city, String state, String nickName) {
        this.city = city;
        this.state = state;
        this.nickName = nickName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }
}
