package User;
import System.*;
import Subscription_plan.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.concurrent.Flow;

public class Customer extends Person {
    private int cusID;
    private subcription subscription;
    private ArrayList<InBody> inBodies;
    private Coach coach;
    private ArrayList<Equipments> gymEquipments;
    public Customer(){

    }
    public Customer(int n,String name, char gender, String address, String phoneNumber, String email,String password) {

        super( name, gender, address, phoneNumber, email,password);

        this.subscription = null;
        this.inBodies = new ArrayList<>();
        this.gymEquipments = new ArrayList<>();
        this.coach = null;
        setCusID(n);
    }

    public String toString() {
        return cusID + " " + gender + " " + getAddress() + " " + getPhoneNumber() + " " + getEmail();
    }

public void setCusID(int n){
        this.cusID=n+1;

}
public int getCusId()
{
    return cusID;
}



    public subcription getSubscription() {
        return subscription;
    }

    public void setSubscription(subcription subscription) {
        this.subscription = subscription;
    }

    public ArrayList<InBody> getInBodies() {
        return inBodies;
    }

    public void addInBody(InBody inBody) {
        inBodies.add(inBody);
    }

    public Coach getCoach() {

        return coach;
    }
    public boolean hasCoach(){
        if(this.coach==null){
            return true;
        }
        else {
        return false;
        }
    }

    public void setCoach(Coach coach) {
        this.coach = coach;
        coach.numberofTrainee++;
    }

    public ArrayList<Equipments> getGymEquipments() {
        return gymEquipments;
    }

    public void addGymEquipment(Equipments equipment) {
        gymEquipments.add(equipment);
    }

    //  Get coach info for the costumer (Name, Phone number, working hours)
    public void getCoachInfo(Customer customer) {
        try {
            Coach customerCoach = customer.getCoach();

            if (customerCoach != null) {
                System.out.println("User.Coach Info for User.Customer " + customer.name + ":");
                customerCoach.displayBasicInfo();
                customerCoach.displayDetails();
            } else {
                System.out.println("No assigned coach for User.Customer " + customer.name + ".");
            }
        } catch (Exception e) {
            System.out.println("Error getting coach info: " + e.getMessage());
        }
    }


    //  Display all Gym Equipment
    public void displayAllGymEquipment() {
        try {
            System.out.println("List of Gym Equipment:");
            for (Equipments equipment : gymEquipments) {
                System.out.println("Name: " + equipment.getName() + ", Quantity: " + equipment.getQuantity());
            }
        } catch (Exception e) {
            System.out.println("Error displaying gym equipment: " + e.getMessage());
        }
    }

    // : Display membership plan details
//    public void displayMembershipPlanDetails() {
//        try {
//            if (subscription != null && subscription instanceof MembershipPlan) {
//                MembershipPlan membershipPlan = (MembershipPlan) subscription;
//                System.out.println("Membership Plan Details:");
//                System.out.println("Start Date: " + membershipPlan.startDate);
//                System.out.println("End Date: " + membershipPlan.endDate);
//                System.out.println("Monthly Plan: " + membershipPlan.MonthlyPlan);
//                System.out.println("Number of Months Registered: " + membershipPlan.no_of_months_registered);
//                System.out.println("Price of the Membership Plan: " + membershipPlan.price_of_the_membership_plan);
//                System.out.println("Days Remaining: " + MembershipPlan.calculateDaysRemaining(membershipPlan.endDate));
//            } else {
//                System.out.println("No membership plan information available.");
//            }
//        } catch (Exception e) {
//            System.out.println("Error displaying membership plan details: " + e.getMessage());
//        }
//    }

    //  Display in-body information at a specific date
    public void displayInBodyInformation(Date specificDate) {
        try {
            boolean found = false;

            for (InBody inBody : inBodies) {
                if (inBody.getDateOfInBody().equals(specificDate)) {
                    System.out.println("subscription_plan.InBody Information at " + specificDate + ":");
                    System.out.println("Date of subscription_plan.InBody: " + inBody.getDateOfInBody());
                    System.out.println("Height: " + inBody.getHeight() + " m");
                    System.out.println("Total Weight: " + inBody.getTotalWeight() + " kg");
                    System.out.println("Body Fat Mass: " + inBody.getBodyFatMass() + " kg");
                    System.out.println("Minerals: " + inBody.getMinerals() + " kg");
                    System.out.println("Total Body Water: " + inBody.getTotalBodyWater() + " kg");
                    System.out.println("Protein: " + inBody.getProtein() + " kg");
                    found = true;
                    break; // Stop searching once found
                }
            }

            if (!found) {
                System.out.println("No subscription_plan.InBody information available for the specified date.");
            }
        } catch (Exception e) {
            System.out.println("Error displaying in-body information: " + e.getMessage());
        }
    }

    //  Function: Calculate BMI
    public double calculateBMI(InBody inBody) {
        return inBody.getTotalWeight() / (inBody.getHeight() * inBody.getHeight());
    }


    //  Display how many kilos need to be reduced according to his body
    public void displayWeightToReduce() {
        try {
            double targetBMI = 25.0; // Set your target BMI
            if (!inBodies.isEmpty()) {
                InBody latestInBody = inBodies.get(inBodies.size() - 1);

                double currentBMI = calculateBMI(latestInBody);
                double targetWeight = targetBMI * (latestInBody.getHeight() * latestInBody.getHeight());

                double weightToReduce = latestInBody.getTotalWeight() - targetWeight;

                System.out.println("Current BMI: " + currentBMI);
                System.out.println("Weight to reduce to achieve BMI of " + targetBMI + ": " + weightToReduce + " kg");
            } else {
                System.out.println("No subscription_plan.InBody information available to calculate weight reduction.");
            }
        } catch (Exception e) {
            System.out.println("Error calculating weight reduction: " + e.getMessage());
        }
    }

    // Override the abstract method in User.Person class
    @Override
    void displayDetails() {
        System.out.println("User.Customer Details:");
        displayBasicInfo();

    }
}
