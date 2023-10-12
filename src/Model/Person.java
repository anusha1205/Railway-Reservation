package Model;

import java.util.Calendar;
import java.util.Date;

public class Person {
    private int id;
    private String name;
    private String email;


    public Person(int passengerId, String name, String email)
    {
        setId(passengerId);
        setName(name);
        setEmail(email);
    }

    public Person(String name, String email)
    {
        int Id = (int) Math.random();
        System.out.println("Passenger Created with Id: "+ Id);
        setId(Id);
        setName(name);
        setEmail(email);
    }

    public void setId(int id) { this.id = id; }
    public void setName(String name)
    {
        this.name = name;
    }
    public void setEmail(String email)
    {
        this.email = email;
    }


    public int getId()
    {
        return this.id;
    }
    public String getName()
    {
        return this.name;
    }
    public String getEmail() { return this.email; }

    final public String display()
    {
        return ("id : "+getId()+ " Name : "+getName()+ " Email : "+getEmail());
    }
}
