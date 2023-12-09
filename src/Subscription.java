import java.io.Serializable;

public class Subscription implements Serializable {
   private int coach_id;
 private int customer_id;
 MemberShipPlan membership;

 public subcription(int customer_id,int coach_id,MemberShipPlan membership){
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
   
    public void displaySubcription() {
        System.out.println("your ID: "+getCustomer_id());
        System.out.println("your coach ID: "+getCoach_id());
        System.out.println("Subscription date"+membership.getStartDate());
        System.out.println("Remaining subscription days: " + membership.calculateDaysRemaining());
    }
}
