import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
public class MembershipPlan  {
    LocalDate startDate;
    LocalDate endDate;
    String MonthlyPlan;
    int no_of_months_registered;
    float price_of_the_membership_plan;

    public MembershipPlan(LocalDate s,LocalDate e ) {
        startDate=s;
        endDate=e;

    }

    public static long calculateDaysRemaining( LocalDate endDate) {
        // Calculate the difference between end date and start date
        return ChronoUnit.DAYS.between(LocalDate.now(), endDate);
    }
}
