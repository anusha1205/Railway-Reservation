package Model;
import java.lang.Math;
/**
 * Identification comments:
 * Name: ANUSHA MAHADEV GONAL
 * Experiment No: 2
 * Experiment Title : Implementing polymorphism using Method and Constructor for
 * String Manipulation in Java
 * Experiment Date : 17-08-2023
 * 
 * @version 1.0
 *
 *
 *          Beginning comments:
 *          Filename: Passenger.java
 * @author: ANUSHA MAHADEV GONAL
 *          /* Overview: This class is created to store the attributes of
 *          Passenger. It is a subclass of the
 *          class "Person" which inherits
 *          some of the attributes from the Person class. And the class
 *          representing the "Person" object
 *          implements the interface named
 *          "Table Member".
 *
 *          Attribute comments:
 *          id : Its Passenger Id
 *          Name :
 *
 *
 */
public class Passenger {
    /* Passenger attributes */
    private int pass_id;
    private String first_name;
    private String middle_name;
    private String last_name;
    private long mobile_no;
    private String email;
    private String address;
    private long aadhar_number;

    public Passenger(int passengerId, String name, long mobile_no, String email, String address, Long aadhar_number) {
        setPass_Id(passengerId);
        String[] split_name = name.split(" ");
        setFirstName(split_name[0]);
        setMiddleName(split_name[1]);
        setLastName(split_name[2]);
        setMobileNo(mobile_no);
        setEmail(email);
        setAddress(address);
        setAadhar_number(aadhar_number);
    }

    public Passenger(String name, long mobile_no, String email, String address, long aadhar_number) {
        int passengerId = (int) Math.random();
        System.out.println("Passenger Created with Id: " + passengerId);
        setPass_Id(pass_id);
        String[] split_name = name.split(" ");
        setFirstName(split_name[0]);
        setMiddleName(split_name[1]);
        setLastName(split_name[2]);
        setMobileNo(mobile_no);
        setEmail(email);
        setAddress(address);
        setAadhar_number(aadhar_number);
    }
    public void setPass_Id(int passengerId) {this.pass_id = passengerId;}
    public void setFirstName(String first_name) {this.first_name = first_name;}
    public void setMiddleName(String middle_name) {this.middle_name = middle_name;}
    public void setLastName(String last_name) {this.last_name = last_name;}
    public void setMobileNo(long mobile_no) {this.mobile_no = mobile_no;}
    public void setEmail(String email) {this.email = email;}
    public void setAddress(String address) {this.address = address;}
    public void setAadhar_number(long aadhar_number) {this.aadhar_number = aadhar_number;}
   
   
    public int getPass_id() {return this.pass_id;}
    public String getFirstName() {return this.first_name;}
    public String getMiddleName() {return this.middle_name;}
    public String getLastName() {return this.last_name;}
    public String getFullName() {return this.getFirstName() + " " + this.getMiddleName() + " " + this.getLastName();}
    public long getMobileNo() {return this.mobile_no;}
    public String getEmail() {return this.email;}
    public String getAddress() {return this.address;}
    public long getAadhar_number() {return this.aadhar_number;}
}
