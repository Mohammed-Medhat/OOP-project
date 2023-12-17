package User;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import System.*;

public class Coach extends Person

{
    public  List <Customer> customerList = new ArrayList<>();
    private  int coId;
     private  int workingHours;
     public int numberofTrainee ;

     public Coach(String name, char gender, String address, String phoneNumber, String email,int workingHours,String password)
     {
         super( name,  gender,  address,  phoneNumber,  email,password);
         coId=Gym.gcoach.size()+1;
         this.workingHours=workingHours;

     }
     public Coach(){};

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

public void showCustomers(){
        if(customerList.isEmpty()){
            System.out.println("There is no Customers this Coach train");
        }
        else{
        for(Customer c:customerList){
        System.out.println(c.getName());
        }
        }
}
    public static void addcoach() {
        Scanner scanner=new Scanner(System.in);
        System.out.print("Enter coach name: ");
        String name = scanner.nextLine();
        System.out.print("Enter coach id : ");
        int coId = scanner.nextInt();
        System.out.println("enter coach gender:");
        char gender = scanner.next().charAt(0);
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
        Gym.gcoach.add(new Coach(name,gender,address,phoneNumber,email,workingHours,password));
    }
    public int findCoach(int id){
        for( int i=0; i<Gym.gcoach.size(); i++ ) {
            if(Gym.gcoach.get(i).getCoId()==id){
            return i;
            }

        }
        return -1;

    }
    public void displayallcoachesinfo(int id){

         for( Coach C :Gym.gcoach ){
             if (C.getCoId()==id) {
                 System.out.println("coach name" + C.getName() + "coach id " + C.getCoId() + "coach gender" + C.getGender() + "address: " + C.getAddress() + " phone  number "
                         + C.getPhoneNumber() + "  email " + C.getEmail() + "working hours : " + C.getWorkingHours() + "number of trainees" + C.getNumberOfTrainee());
             }
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
    public int login(String username, String password) {
        for (int i = 0; i < Gym.gcoach.size(); i++) {
            Coach coach= Gym.gcoach.get(i);
            if (coach.getEmail().equals(username) && coach.getPassword().equals(password)) {

                return i;

            }
        }
        return -1;
    }

    @Override
    public void displayDetails()
    {
        System.out.println("Working Hours: " + workingHours);
    }

}
