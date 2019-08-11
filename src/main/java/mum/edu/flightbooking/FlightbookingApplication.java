package mum.edu.flightbooking;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@SpringBootApplication
public class FlightbookingApplication {

    public static void main(String[] args) {


//          String
//          jdbcUrl="jdbc:mysql://localhost:3306/flight_booking_db?useSSL=false";
//
//          String user = "root"; String pass = "root"; try {
//          System.out.println("Connecting to database: "+ jdbcUrl); Connection
//          myConn=DriverManager.getConnection(jdbcUrl, user, pass);
//          System.out.println("succesfull"); }catch (Exception e) { e.printStackTrace();
//          }

        SpringApplication.run(FlightbookingApplication.class, args);
    }

}
