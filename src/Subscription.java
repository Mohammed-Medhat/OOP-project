import java.io.Serializable;

public class Subscription implements Serializable {
   private int coach_id;
 private int customer_id;
 MembershipPlan membership;

 public Subscription(int customer_id,int coach_id,MembershipPlan membership){
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
   public String toString()
   {
      return getCoach_id() + " " + getCustomer_id();
   }
   
    public void displaySubcription() {
        System.out.println("your ID: "+getCustomer_id());
        System.out.println("your coach ID: "+getCoach_id());
        System.out.println("Subscription date"+membership.getStartDate());
        System.out.println("Remaining subscription days: " + membership.calculateDaysRemaining());
    }
}
