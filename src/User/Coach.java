package User;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Coach extends Person

{
    public static List <Coach> gcoach = new ArrayList<>();
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


    public static void addcoach(List <Coach> gcoach ) {
        Scanner scanner=new Scanner(System.in);
        System.out.print("Enter coach name: ");
        String name = scanner.nextLine();
        System.out.print("Enter coach id : ");
        int coId = scanner.nextInt();
        System.out.println("enter coach gender:");
        String gender = scanner.next();
        System.out.println("enter coach address:");
        String address = scanner.nextLine();
        System.out.println("enter phone number:");
        String phoneNumber=scanner.nextLine();
        System.out.println("enter email:");
        String email=scanner.nextLine();
        System.out.println("enter working Hours");
        int workingHours = scanner.nextInt();
        System.out.println("enter password");
        String password= scanner.nextLine();
        System.out.println("enter number of trainees:");
        int numberofTrainee= scanner.nextInt();
    }
    public void displayallcoachesinfo(){
         for( Coach C :gcoach ){
             System.out.println("coach name"+name +"coach id "+coId+"coach gender"+gender+"address: "+getAddress()+" phone  number "
                     +getPhoneNumber()+"  email "+getEmail()+"working hours : "+workingHours+"password"+getPassword()
             + "number of trainees"+numberofTrainee);

         }

    }


    public boolean isIdExists(int id, List <Coach> existingCoaches) {
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
