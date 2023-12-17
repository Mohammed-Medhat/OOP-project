package Subscription_plan;
import User.Customer;
import System.*;
import java.util.Scanner;

public class subcription {
 private int coach_id;
 private int customer_id;
 MembershipPlan membership;
    Scanner scanner = new Scanner(System.in);

 public subcription(int customer_id, int coach_id,MembershipPlan membership){
     this.customer_id =customer_id;
     this.coach_id = coach_id;
     this.membership = membership;
 }

    public int getCoach_id() {
        return coach_id;
    }

    public int getCustomer_id() {
        return customer_id;
    }

    public MembershipPlan getMembership() {
        return membership;
    }

    public String toString(){
     return getCustomer_id() + " " + getCoach_id() + " " + membership;
    }

    public void displaySubcription() {

        System.out.println("your ID: " + getCustomer_id());
        System.out.println("your coach ID: " + getCoach_id());

        if (membership.calculateDaysRemaining() > 0) {
            System.out.println("your plan: " + membership.getMonthlyPlan());
            System.out.println("Remaining subscription days: " + membership.calculateDaysRemaining());
        }
        else
            System.out.println("your membership was ended");
    }


    public void historySubscriptions(){

        System.out.println("Enter Customer ID to show his subscription history:");
        int id_history = scanner.nextInt();
        if (id_history == getCustomer_id()) {
            System.out.println(" ID: " + getCustomer_id());
            System.out.println("coach ID: " + getCoach_id());
            System.out.println("registerd: " + membership.getNo_of_months_registered() + "months");
            System.out.println("start date: " + membership.getStartDate());
            System.out.println("End date: " + membership.getEndDate());
        }


    }
    public void Display_all_the_customers_that_subscribed_to_the_gym_in_a_given_month(int MorD){
        System.out.println("1-Day(d)   2-Month(m)");
        char x=scanner.nextLine().charAt(0);

        for(Customer c: Gym.gcus){
            if(c.getMembership().getStartDate().getMonthValue()== MorD && x == 'm') {

                System.out.println(c.getName());

            }
            else if(x=='d'&&c.getMembership().getStartDate().getDayOfMonth()== MorD){
                System.out.println(c.getName());
            }
        }


    }


 }






