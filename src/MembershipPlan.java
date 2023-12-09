import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
public class MembershipPlan  {
    private LocalDate startDate;
    private LocalDate endDate;
    private String MonthlyPlan;
    private int no_of_months_registered;
    private float price_of_the_membership_plan;

    public MembershipPlan(LocalDate startDate, LocalDate endDate, String MonthlyPlan, int no_of_months_registered, float price_of_the_membership_plan) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.MonthlyPlan = MonthlyPlan;
        this.no_of_months_registered = no_of_months_registered;
        this.price_of_the_membership_plan = price_of_the_membership_plan;
    }
    public void LocalDate setStartDate(LocalDate start)
    {
        startDate = start;
    }
    
    public LocalDate getStartDate()
    {
        return startDate;
    }
     public void LocalDate setEndDate(LocalDate end){
         endDate = end;
     }
    public LocalDate getEndDate(){
        return endDate;
    }

    public static long calculateDaysRemaining( LocalDate endDate) {
        // Calculate the difference between end date and start date
        return ChronoUnit.DAYS.between(LocalDate.now(), endDate);
    }
}
