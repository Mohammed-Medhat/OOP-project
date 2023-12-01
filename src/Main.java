import java.time.LocalDate;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        LocalDate s = LocalDate.of(2023,5,5);
        LocalDate e=LocalDate.of(2024,7,7);
        MembershipPlan m=new MembershipPlan(s,e);
        System.out.println("Remaining days: " + m.calculateDaysRemaining(e));
    }
}