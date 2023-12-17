package User;

import java.io.Serializable;
import java.util.List;

abstract public class Person implements Serializable {

    public String name;
    public char gender;
    private String address;
    private String phoneNumber;
    private String email;
    private String password;

    public Person(String name, char gender, String address, String phoneNumber, String email, String password) {

        this.name = name;
        this.gender = gender;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.password = password;
    }

    protected Person() {
    }
    public abstract int login(String username,String password) ;

    public String getPassword() {
        return password;
    }

    public String getName() {
        return name;
    }


    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    // abstract functions to be used in coach and costumer
    abstract void displayDetails();

    // show the basicInfo for costumer and coach
    public void displayBasicInfo() {

        System.out.println("Name: " + name);
        System.out.println("Gender: " + gender);
        System.out.println("Address: " + getAddress());
        System.out.println("Phone Number: " + getPhoneNumber());
        System.out.println("Email: " + getEmail());
    }


    protected void setName(String name) {
        this.name = name;
    }

    protected char getGender() {
        return gender;
    }

    protected void setGender(char gender) {
        this.gender = gender;
    }

}


