package subscription_plan;
import java.time.LocalDate;
import java.util.Scanner;

public class subcription {
 private int coach_id;
 private int customer_id;
 MembershipPlan membership;
    Scanner scanner = new Scanner(System.in);

 public subcription(int customer_id,int coach_id,MembershipPlan membership){
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


        System.out.println(" ID: " + getCustomer_id());
        System.out.println("coach ID: " + getCoach_id());
        System.out.println("registerd: " + membership.getNo_of_months_registered() + "months");
        System.out.println("start date: " + membership.getStartDate());
        System.out.println("End date: " + membership.getEndDate());


    }

public void checkCustomersInMonth(){
    System.out.println("enter month:");
    int month = scanner.nextInt();
    if (month == membership.getNo_of_months_registered()){
        System.out.println(getCustomer_id());
    }
}



}
