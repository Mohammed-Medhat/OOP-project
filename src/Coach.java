import java.util.ArrayList;
import java.util.List;
public class Coach extends Person

{
    private int coId;
     private  int workingHours;
     public int numberofTrainee ;

     public Coach(String name, char gender, String address, String phoneNumber, String email,int workingHours,String password,int numberofTrainee,int n)
     {
         super( name,  gender,  address,  phoneNumber,  email,password);
         setCoId(n);
         this.workingHours=workingHours;
         this.numberofTrainee=numberofTrainee;
     }

    public String toString() {
        return coId + " " + gender + " " + getAddress() + " " + getPhoneNumber() + " " + getEmail();
    }

    public void setCoId(int n) {
        this.coId = n+1;
    }

    public int getCoId() {
        return coId;
    }

    public int getWorkingHours() {
        return workingHours;
    }

    public void setWorkingHours(int workingHours) {
        this.workingHours = workingHours;
    }

    public int getNumberOfTrainee() {
        return numberofTrainee;
    }

    private boolean isIdExists(int id, List <Coach> existingCoaches) {
        // Check if the ID already exists in the list of coaches
        for (Coach coach : existingCoaches) {
            if (coach.getCoId() == id) {
                return true; // ID already exists
            }
        }
        return false; // ID is unique
    }

    @Override
    public void displayDetails()
    {
        System.out.println("Working Hours: " + workingHours);
    }
}
