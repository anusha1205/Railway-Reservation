package Model;
import java.lang.Math;
import java.util.Calendar;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Identification comments:
 *   Name: ANUSHA MAHADEV GONAL & MAYURESH MUKESH GUJARE
 *   Experiment No:
 *   Experiment Title:
 *   Experiment Date:
 *   @version 1.0
 *
 *
 * Beginning comments: 
 * Filename: Passenger.java
 * @author:  ANUSHA MAHADEV GONAL & MAYURESH MUKESH GUJARE
 * /*  Overview: This class is created to store the attributes of Passenger. It is a subclass of the class "Person" which inherits
some of the attributes from the Person class. And the class representing the "Person" object implements the interface named 
"Table Member".
 *
 * Attribute comments: 
 * id : Its Passenger Id
 * Name :
 * DOB : 
 *
 *
 */

public class Passenger extends Person {

    /* Passenger attributes */
    private String address;
    private long aadhar_number;

    public Passenger(int passengerId, String name, String email, String address, Long aadhar_number) {
        super(passengerId, name, email);
        setAddress(address);
        setAadhar_number(aadhar_number);
    }
    public Passenger(String name, long mobile_no, String email, String address, long aadhar_number) {
        super(name, email);
        setAddress(address);
        setAadhar_number(aadhar_number);
    }

    public void setAddress(String address) {
        this.address = address;
    }
    public void setAadhar_number(long aadhar_number) {
        this.aadhar_number = aadhar_number;
    }
    public String getAddress() {
        return this.address;
    }
    public long getAadhar_number() {
        return this.aadhar_number;
    }

    public String displayPassenger()
    {
        return display() +" ,Address :"+this.getAddress()+" ,Aadhar number :"+this.getAadhar_number();
    }

}
