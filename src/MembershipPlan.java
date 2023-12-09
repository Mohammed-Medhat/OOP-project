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

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public static LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public String getMonthlyPlan() {
        return MonthlyPlan;
    }

    public void setMonthlyPlan(String monthlyPlan) {
        MonthlyPlan = monthlyPlan;
    }

    public int getNo_of_months_registered() {
        return no_of_months_registered;
    }

    public void setNo_of_months_registered(int no_of_months_registered) {
        this.no_of_months_registered = no_of_months_registered;
    }

    public float getPrice_of_the_membership_plan() {
        return price_of_the_membership_plan;
    }

    public void setPrice_of_the_membership_plan(float price_of_the_membership_plan) {
        this.price_of_the_membership_plan = price_of_the_membership_plan;
    }
    
    public String toString()
    {
        return getStartDate() + " " +getEndDate() + " " + getMonthlyPlan() + " " + getNo_of_months_registered() + " " + getNo_of_months_registered() + " " + getPrice_of_the_membership_plan();
    }

    public static long calculateDaysRemaining() {
        // Calculate the difference between end date and start date
        return ChronoUnit.DAYS.between(LocalDate.now(), getEndDate());
    }

}
