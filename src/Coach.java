public class Coach extends Person
{
     public  int workingHours;

     public Coach(String name, char gender, String address, String phoneNumber, String email,int workingHours,String password)
     {
         super( name,  gender,  address,  phoneNumber,  email,password);
         this.workingHours=workingHours;
     }
    public String toString() {
        return  getId()+ gender +getAddress()+getPhoneNumber()+getEmail();
    }

    @Override
    public void displayDetails()
    {
        System.out.println("Working Hours: " + workingHours);
    }
}
