import java.io.Serializable;

abstract public class Person implements Serializable {
    private static int id;
    public String name;
    public char gender;
    private String address;
    private String phoneNumber;
    private String email;
    private String password;


    public Person( String name, char gender, String address, String phoneNumber, String email,String password ) {
        this.id++;
        this.name = name;
        this.gender = gender;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.password=password;
    }
   public String getPassword(){
        return password;
   }
    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String  getPhoneNumber() {
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
        System.out.println("ID: " + getId());
        System.out.println("Name: " + name);
        System.out.println("Gender: " + gender);
        System.out.println("Address: " + getAddress());
        System.out.println("Phone Number: " + getPhoneNumber());
        System.out.println("Email: " + getEmail());
    }

}
