public class Coach extends Person
{
     public  int workingHours;

     public Coach(int id, String name, char gender, String address, int phoneNumber, String email,int workingHours)
     {
         super( id,  name,  gender,  address,  phoneNumber,  email);
         this.workingHours=workingHours;
     }

    @Override
    public void displayDetails()
    {
        System.out.println("Working Hours: " + workingHours);
    }
}
