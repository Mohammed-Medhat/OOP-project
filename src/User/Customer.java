package User;

import Subscription_plan.InBody;
import Subscription_plan.MembershipPlan;
import Subscription_plan.subcription;
import System.Equipments;
import System.*;
import Subscription_plan.*;
import jdk.jshell.JShell;

import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

import static System.Gym.gcus;
import static System.Gym.gequipment;

public class Customer extends Person {
    private static int cusID;
    private ArrayList<subcription> subscription = new ArrayList<>();
    private ArrayList<InBody> inBodies;
    private Coach coach;
    private ArrayList<Equipments> gymEquipments;
    private MembershipPlan membership;
    private static final double TARGET_BMI = 25.0;

    public Customer(int n, String name, char gender, String address, String phoneNumber, String email, String password) {

        super(name, gender, address, phoneNumber, email, password);

        subscription = null;
        this.inBodies = new ArrayList<>();
        this.gymEquipments = new ArrayList<>();
        this.coach = null;
        this.membership = null;
        setCusID(n);
    }

    public Customer() {
    }

    ;

    public String toString() {
        return cusID + " " + gender + " " + getAddress() + " " + getPhoneNumber() + " " + getEmail();
    }

    public MembershipPlan getMembership() {
        return membership;
    }

    public void setMembership(MembershipPlan membership) {
        this.membership = membership;
    }

    public void setCusID(int n) {
        cusID = n + 1;

    }

    public static int getCusId() {
        return cusID;
    }


    public subcription getSubscription() {
        return subscription.get(subscription.size() - 1);
    }

    public void setSubscription(subcription subscription) {
        Subscription_plan.subcription sub = subscription;
        this.subscription.add(subscription);
    }

    public ArrayList<InBody> getInBodies() {
        return inBodies;
    }

    public void addInBody(InBody inBody) {
        inBodies.add(inBody);
    }

    public Coach getCoach() {
        return coach;
    }

    public boolean hasCoach() {
        return this.coach != null;
    }

    public void setCoach(Coach coach) {
        this.coach = coach;
        coach.numberofTrainee++;
    }

    public ArrayList<Equipments> getGymEquipments() {
        return gymEquipments;
    }

    public void addGymEquipment(Equipments equipment) {
        gymEquipments.add(equipment);
    }

    //  Get coach info for the costumer (Name, Phone number, working hours)
    public void getCoachInfo(Customer customer) {
        try {
            Coach customerCoach = customer.getCoach();

            if (customerCoach != null) {
                System.out.println("Coach Info for Customer " + customer.name + ":");
                customerCoach.displayBasicInfo();
                customerCoach.displayDetails();
            } else {
                System.out.println("No assigned coach for Customer " + customer.name + ".");
            }
        } catch (Exception e) {
            System.out.println("Error getting coach info: " + e.getMessage());
        }
    }


    //  Display all Gym Equipment
    public void displayGymEquipmentList() {
        try {
            System.out.println("List of Gym Equipment:");
            for (Equipments equipment : gequipment) {
                System.out.println("Name: " + equipment.getName() + ", Quantity: " + equipment.getQuantity());
            }
        } catch (Exception e) {
            System.out.println("Error displaying gym equipment: " + e.getMessage());
        }
    }

    // : Display membership plan details
    public void displayMembershipPlanDetails() {
        try {
            if (subscription != null && membership != null) {
                System.out.println("Membership Plan Information:");
                System.out.println("Customer ID: " + getCusId());
                System.out.println("Customer Name: " + name);
                System.out.println("Subscription date: " + membership.getStartDate());
                System.out.println("Remaining subscription days: " + membership.calculateDaysRemaining());
                System.out.println("Monthly Plan: " + membership.getMonthlyPlan());
                System.out.println("Number of months registered: " + membership.getNo_of_months_registered());
                System.out.println("Price of the membership plan: " + membership.getPrice());
            } else {
                System.out.println("No membership plan information available.");
            }
        } catch (Exception e) {
            System.out.println("Error displaying membership plan details: " + e.getMessage());
        }
    }

    //  Display in-body information at a specific date
    public void displayInBodyInformation(Date specificDate) {
        try {
            boolean found = false;

            for (InBody inBody : inBodies) {
                if (inBody.getDateOfInBody().equals(specificDate)) {
                    System.out.println("InBody Information at " + specificDate + ":");
                    System.out.println("Date of InBody: " + inBody.getDateOfInBody());
                    System.out.println("Height: " + inBody.getHeight() + " m");
                    System.out.println("Total Weight: " + inBody.getTotalWeight() + " kg");
                    System.out.println("Body Fat Mass: " + inBody.getBodyFatMass() + " kg");
                    System.out.println("Minerals: " + inBody.getMinerals() + " kg");
                    System.out.println("Total Body Water: " + inBody.getTotalBodyWater() + " kg");
                    System.out.println("Protein: " + inBody.getProtein() + " kg");
                    found = true;
                    break; // Stop searching once found
                }
            }

            if (!found) {
                System.out.println("No InBody information available for the specified date.");
            }
        } catch (Exception e) {
            System.out.println("Error displaying in-body information: " + e.getMessage());
        }
    }

    //  Function: Calculate BMI
    public double calculateBMI(InBody inBody) {
        return inBody.getTotalWeight() / (inBody.getHeight() * inBody.getHeight());
    }


    //  Display how many kilos need to be reduced according to his body
    public void displayWeightToReduce() {
        try {
            if (!inBodies.isEmpty()) {
                InBody latestInBody = inBodies.get(inBodies.size() - 1);

                double currentBMI = calculateBMI(latestInBody);
                double targetWeight = TARGET_BMI * (latestInBody.getHeight() * latestInBody.getHeight());

                double weightToReduce = latestInBody.getTotalWeight() - targetWeight;

                System.out.println("Current BMI: " + currentBMI);
                System.out.println("Weight to reduce to achieve BMI of " + TARGET_BMI + ": " + weightToReduce + " kg");
            } else {
                System.out.println("No InBody information available to calculate weight reduction.");
            }
        } catch (Exception e) {
            System.out.println("Error calculating weight reduction: " + e.getMessage());
        }
    }

    public static void createSampleCustomer() {
        // For testing purposes, you can hardcode some values or take input from the user.
        System.out.println("Enter customer details");
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter customer ID: ");
        int customerId = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        System.out.print("Enter customer name: ");
        String customerName = scanner.nextLine();

        System.out.print("Enter gender (M/F): ");
        char gender = scanner.next().charAt(0);

        System.out.print("Enter address: ");
        String address = scanner.next(); // Assuming a single-word address for simplicity

        System.out.print("Enter phone number: ");
        String phoneNumber = scanner.next();

        System.out.print("Enter email: ");
        String email = scanner.next();

        System.out.print("Enter password: ");
        String password = scanner.next();

        Customer customer = new Customer(customerId, customerName, gender, address, phoneNumber, email, password);
        Gym.gcus.add(customer);
    }

    public static boolean iscustExists(int customerId) {
        for (Customer customer : gcus) {
            if (getCusId() == customerId) {
                return true; // Customer ID already exists
            }
        }
        return false; // Customer ID is unique
    }

    public void Show_the_subscription_history_for_a_customer(int id) {
        for (Customer c : gcus) {
            if (getCusId() == id) {
                for (int i = 0; i < c.subscription.size(); i++) {
                    System.out.println(c.subscription.get(i).getMembership().getPrice());
                }
            }
        }
    }

    @Override
    public int login(String username, String password) {

        for (int i = 0; i < gcus.size(); i++) {
            Customer customer = gcus.get(i);
            if (customer.getEmail().equals(username) && customer.getPassword().equals(password)) {

                return i;

            }
        }
        return -1;
    }

    @Override
    public void signup(String email) {
        boolean flag = false;
        for (Customer customer : gcus) {
            if (email.equals(customer.getEmail())) {
                flag = true;
                break;

            }
        }
        if (flag == true) {
            System.out.println("Already exist");
        } else {
            createSampleCustomer();
        }
    }


    // Override the abstract method in Person class
    @Override
    public void displayDetails() {
        System.out.println("Customer Details:");
        System.out.println("Email: " + getEmail());
        System.out.println("Address: " + getAddress());
        System.out.println("Gender: " + gender);

    }
}


