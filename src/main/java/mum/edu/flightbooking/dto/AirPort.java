package mum.edu.flightbooking.dto;

public class AirPort {
    private String nickName;

    public AirPort(){}
    public AirPort(String nickName) {
        this.nickName = nickName;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }
}
