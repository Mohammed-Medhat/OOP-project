package Subscription_plan;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

public class MembershipPlan  {
    private LocalDate startDate;
    private LocalDate endDate;
    private String MonthlyPlan;
    private int no_of_months_registered;
    private int price;

    Scanner scanner = new Scanner(System.in);

    public MembershipPlan(LocalDate startDate, LocalDate endDate, String MonthlyPlan, int no_of_months_registered, int price) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.MonthlyPlan = MonthlyPlan;
        this.no_of_months_registered = no_of_months_registered;
        this.price = price;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public String getMonthlyPlan() {
        return MonthlyPlan;
    }

    public int getNo_of_months_registered() {
        return no_of_months_registered;
    }

    public int getPrice() {
        return price;
    }

    public String toString(){
        return MonthlyPlan +" "+ no_of_months_registered + " " + price +" "+ getStartDate() +" "+ getEndDate();
    }


    public void showMonthsRegistered(){
        System.out.println("1 Month: 600 L.E\n" +
                "3 Months: 1500 (discount 15%)\n" +
                "   1 InBody" +
                "   1 freezing (for one month)" +

                "6 Months: 2500 (discount 30%)\n" +
                "   1 InBody" +
                "   2 freezing (for one month)" +
                "9 Months: 3200 (discount 40%)\n" +
                "   2 InBody" +
                "   2 freezing (for two month)" +
                "1 year: 4000 (discount 44%)\n" +
                "   3 InBody" +
                "   3 freezing (two month)" );
    }

    public void chooseMonthRegister(){
        System.out.println("Register Months" +
                "choose 1 for 1 months" +
                "2 for 3 months" +
                "3 for 6 months" +
                "4 for 9 months" +
                "5 for 1 year");
        int y = scanner.nextInt();
        if (y == 1) {
            no_of_months_registered = 1;
            price = 600;
        } else if (y == 2) {
            no_of_months_registered = 3;
            price = 1500;
        }
        else if (y == 3) {
            no_of_months_registered = 6;
            price = 2500;
        }
        else if (y == 4) {
            no_of_months_registered = 9;
            price = 3200;
        }
        else if (y == 5) {
            no_of_months_registered = 12;
            price = 4000;
        }

    }





    public void displayMonthlyPlan() {
        System.out.println("3 days per week plan:\n" +
                "day1: push\n" +
                " day2: Pull\n" +
                " day3: Leg");

        System.out.println("6 days per week plan:\n" +
                "day1: chest\n" +
                "day2: back\n" +
                "day3: shoulders\n" +
                "day4: bicips and tricips\n" +
                "day5: Leg\n" +
                "day6: cardio");
    }
    public int chooseMonthlyPlan() {
        System.out.println("choose (1) for 3 days per week plan\n and (2) for 6 days per week");
        int x = scanner.nextInt();
        if (x == 1) {
            MonthlyPlan.equals("3 days per week:" +
                    "day1: push\n" +
                    "day2: Pull\n" +
                    "day3: Leg");
            System.out.println(MonthlyPlan + "is your plan");
        } else if (x == 2) {
            MonthlyPlan.equals("6 days per week:" +
                    "day1: chest\n" +
                    "day2: back\n" +
                    "day3: shoulders\n" +
                    "day4: bicips and tricips\n" +
                    "day5: Leg\n" +
                    "day6: cardio");
            System.out.println(MonthlyPlan + "is your plan");
        }
        else {
            System.out.println("Invalid");
            return -1;
        }
        return 1;
    }






    public  long calculateDaysRemaining() {
        // Calculate the difference between end date and start date
        return ChronoUnit.DAYS.between(LocalDate.now(), getEndDate());
    }
}
