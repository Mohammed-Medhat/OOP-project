package System;

import User.*;
import System.*;
import Subscription_plan.*;
import java.util.Scanner;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.*;
import static User.Coach.addcoach;
import static User.Customer.createSampleCustomer;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("sign as \n1-Admin\n2-Customer \n3-Coach\n");
        int type = scanner.nextInt();
        scanner.nextLine();
        String filePathPerson = "C:\\Users\\iShop\\IdeaProjects\\OOP project\\Person.txt";
        //   String filePathequi = "C:\\Users\\iShop\\IdeaProjects\\OOP project\\Equipment.txt";
        System.out.print("Username\n");
        String username= scanner.nextLine();
        System.out.print("Username\n");
        String password= scanner.nextLine();

//
//

//User.Customer addded in files
//        c1.add(new User.Customer(0, "Mohammed", 'm', "ain shams", "01014487283", "mo@gmail.com", "mamadou"));
//
//        c1.add(new User.Customer(1, "othman", 'm', "8 meter", "01215312105", "mo@gmail.com", "3ossjr"));
//
//        c1.add(new User.Customer(2,"hady",'m',"obor","01215643211","mo@gmail.com","12345"));
//
//        c1.add(new User.Customer(3,"ali",'m',"maadi","01562156463","mo@gmail.com","12345"));

//        //equipment added in files
//
//        //coaches added in files
//        c.add(new User.Coach("big rammi", 'M', "ainshams", "152316", "rami@gmail.com", 7, "123456789"));
//
//
//       c.add(new User.Coach("fargymawi", 'M', "abbasia", "152316", "far@gmail.com", 7, "123456789"));
//
//        c.add(new User.Coach("Cbunk",'M',"obor","152316","bunk@gmail.com",7,"123456789"));


        List<Person> personList = Files.readPeopleFromFile(filePathPerson);
//        List<Person>personList=new ArrayList<>();
//        personList.addAll(c);
//        personList.addAll(c1);


        for (Person person : personList) {
            if (person instanceof Coach) {
                Coach loadedCoach = (Coach) person;
                Gym.gcoach.add(loadedCoach);
            } else if (person instanceof Customer) {
                Customer loadedCustomer = (Customer) person;
                Gym.gcus.add(loadedCustomer);
            }
        }
boolean close=true;
     while(close) {
    switch (type) {

// Admin functions////////////////////////////////////////////////////////////////////////////////////////////////////


        case 1:
            Admin admin=new Admin();
            int x1=admin.login(username,password);
            boolean exit1=true;
            while (exit1) {
                displayMenuAdmin();
                int choice = scanner.nextInt();
                scanner.nextLine();
                switch (choice) {
                    case 1:
                        Gym.gcoach.get(0).addcoach();
                        
                        break;
                    case 2:
                        admin.displayCoachesSortedByAssignedCustomers();

                        break;
                    case 3:
                        Gym.gcus.get(0).getMembership().displayGYMIncomeInGivenMonth(scanner.nextInt());

                        break;
                    case 4:
                        Gym.gcus.get(0).getSubscription().Display_all_the_customers_that_subscribed_to_the_gym_in_a_given_month(scanner.nextInt());

                        break;
                    case 5:
                        System.out.println("Pleas enter Coach ID:");
                        Gym.gcus.get(0).Show_the_subscription_history_for_a_customer(scanner.nextInt());
                        break;
                    case 6:
                        System.out.println("Pleas enter Coach ID:");
                        int CoachID= Gym.gcoach.get(0).findCoach(scanner.nextInt());
                        Gym.gcoach.get(CoachID).showCustomers();
                        break;
                    case 7:
                        System.out.println("Exiting program.");
                        exit1=false;
                        close=false;
                        break;

                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            }
            break;

         // costumer functions//////////////////////////////////////////////////////////////////////////////////


        case 2:
            Customer customer=new Customer();
            int x2=customer.login(username,password);
            boolean exit2=true;
            while(exit2)
            {
                displayMenu();
                int choice = scanner.nextInt();
                scanner.nextLine();

                switch (choice) {
                    case 1:
                        Gym.gcus.get(x2).getCoachInfo(Gym.gcus.get(x2));
                        break;
                    case 2:
                        Gym.gcus.get(x2).displayGymEquipmentList();
                        break;
                    case 3:
                        Gym.gcus.get(x2).displayMembershipPlanDetails();
                        break;
                    case 4:
                        System.out.println("Enter the specific date (yyyy-mm-dd): ");
                        String dateString = scanner.next();
                        Date specificDate = parseDate(dateString);
                        Gym.gcus.get(x2).displayInBodyInformation(specificDate);
                        break;
                    case 5:
                        Gym.gcus.get(x2).displayWeightToReduce();
                        break;
                    case 6:
                        Gym.gcus.get(x2).displayDetails();
                        break;
                    case 7:
                        System.out.println("Exiting program.");
                        exit2=false;
                        close=false;
                        break;

                    default:
                        System.out.println("Invalid choice. Please try again.");
                }


            }
//coach functions//////////////////////////////////////////////////////////////////////////////////////////////////////////////////


        case 3:
            Coach coach=new Coach();
            int x3=coach.login(username,password);
            break;

        case 4:
            System.out.println("Exiting program.");
            System.exit(0);
            break;
        default:
            System.out.println("Invalid choice. Please try again.");

    }
}






        personList.clear();
        personList.addAll(Gym.gcus);
        personList.addAll(Gym.gcoach);
        System.out.println(personList.size());
        Files.writePeopleToFile(personList, filePathPerson);

    }
    // menu for costumer functions
    private static void displayMenu() {
        System.out.println("Choose an option:");
        System.out.println("1. Display Coach Info");
        System.out.println("2. Display Gym Equipment List");
        System.out.println("3. Display Membership Plan Details");
        System.out.println("4. Display In-Body Information at Specific Date");
        System.out.println("5. Display Weight to Reduce");
        System.out.println("6. Display Customer Details");
        System.out.println("7. Exit");
        System.out.print("Enter your choice: ");
    }
    private static void displayMenuAdmin() {
        System.out.println("Choose an option:");
        System.out.print("1.Add Coach                                                                 2.Display the coaches sorted in terms of the most assigned number of customers to the coaches.\n" +
                         "3.Display the GYM income in a given month.                                  4.Display all the customers that subscribed to the gym in a given month or a day \n" +
                         "5.Show the subscription history for a customer.                             6.Display all the customers of a specific coach.\n");

        System.out.print("Enter your choice: ");
    }
    private static void displayMenuCoach() {
        System.out.println("Choose an option:");
        System.out.println("1. Show a list of all his customers.");
        System.out.println("2. Get the inbody history of any of his customers.");
        System.out.println("3. Get all the details of a customer by his name.");
        System.out.println("4. Show a list of all his female/male customers.");
        System.out.println("5. Exit");
        System.out.print("Enter your choice: ");
    }

    private static Date parseDate(String dateString) {
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            return dateFormat.parse(dateString);
        } catch (ParseException e) {
            System.out.println("Error parsing date: " + e.getMessage());
            return null;
        }
    }

}




