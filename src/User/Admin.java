package User;
import System.Equipments;




import java.io.Serializable;
import java.util.Comparator;
import java.util.List;

import static System.Gym.*;

public class Admin extends Person implements Serializable {

    public Admin() {

    }
    public Admin(String name, char gender, String address, String phoneNumber, String email, String password) {
        super(name, gender, address, phoneNumber, email, password);
    }

    @Override
    void displayDetails() {

    }

    // Additional admin-specific methods
    public boolean isIdExists(int id, List<Coach> existingCoaches) {
        // Check if the ID already exists in the list of coaches
        for (Coach coach : existingCoaches) {
            if (coach.getCoId() == id) {
                return true; // ID already exists
            }
        }
        return false; // ID is unique
    }

    public void addCoach(Coach coach) {
        // Check if the coach ID already exists

        if (!isIdExists(coach.getCoId(), gcoach)) {
            gcoach.add(coach);
            System.out.println("Coach added successfully.");
        } else {
            System.out.println("Coach with the same ID already exists. Please choose a different ID.");
        }
    }


    public void editCoach(Coach updatedCoach) {
        int coachIdToUpdate = updatedCoach.getCoId();

        // Check if the coach with the given ID exists
        boolean coachExists = false;
        for (int i = 0; i < gcoach.size(); i++) {
            Coach existingCoach = gcoach.get(i);
            if (existingCoach.getCoId() == coachIdToUpdate) {
                coachExists = true;
                // Update coach properties with the new values
                existingCoach.setName(updatedCoach.getName());
                existingCoach.setGender(updatedCoach.getGender());
                existingCoach.setAddress(updatedCoach.getAddress());
                existingCoach.setPhoneNumber(updatedCoach.getPhoneNumber());
                existingCoach.setEmail(updatedCoach.getEmail());
                existingCoach.setWorkingHours(updatedCoach.getWorkingHours());

                System.out.println("Coach updated successfully.");
                break;
            }
        }

        if (!coachExists) {
            System.out.println("Coach with ID " + coachIdToUpdate + " not found.");
        }
    }


    public void deleteCoach(Coach deletecoach) {
        // Implement coach deletion logic
        int coachIdTodelete = deletecoach.getCoId();

        // Check if the coach with the given ID exists
        boolean coachExists = false;
        for (int i = 0; i < gcoach.size(); i++) {
            Coach existingCoach = gcoach.get(i);
            if (existingCoach.getCoId() == coachIdTodelete) {
                coachExists = true;
                // Update coach properties with the new values
                gcoach.remove(i);
                System.out.println("Coach Deleted successfully.");
                break;
            }
        }

        if (!coachExists) {
            System.out.println("Coach with ID " + coachIdTodelete + " not found.");
        }
    }

//    equipments to be called
    public void addEquipment(Equipments equipment) {
        // Custom function to check if the equipment code already exists
    }

    public void editEquipment(Equipments equipment) {
        // Implement equipment editing logic
    }

    public void deleteEquipment(Equipments equipment) {
        // Implement equipment deletion logic
    }

    public void addCus(Customer cus) {
        // Check if the coach ID already exists

        if (!Customer.iscustExists(cus.getCusId(), gcus)) {
            gcus.add(cus);
            System.out.println("Customer added successfully.");
        } else {
            System.out.println("Customer with the same ID already exists. Please choose a different ID.");
        }
    }


        public void editCustomer(Customer updatedCustomer) {
            int customerIdToUpdate = updatedCustomer.getCusId();

            // Check if the coach with the given ID exists
            boolean cutomerExists = false;
            for (int i = 0; i < gcus.size(); i++) {
                Customer existingCustomers = gcus.get(i);
                if (existingCustomers.getCusId() == customerIdToUpdate) {
                    cutomerExists = true;
                    // Update coach properties with the new values
                    existingCustomers.setName(updatedCustomer.getName());
                    existingCustomers.setGender(updatedCustomer.getGender());
                    existingCustomers.setAddress(updatedCustomer.getAddress());
                    existingCustomers.setPhoneNumber(updatedCustomer.getPhoneNumber());
                    existingCustomers.setEmail(updatedCustomer.getEmail());
                    existingCustomers.setSubscription(updatedCustomer.getSubscription());
                    existingCustomers.setCoach(updatedCustomer.getCoach());

                    System.out.println("Customer updated successfully.");
                    break;
                }
            }

            if (!cutomerExists) {
                System.out.println("Customer with ID " + customerIdToUpdate + " not found.");
            }
        }


//    public void deleteCustomer(Customer customer) {
//        // Implement customer deletion logic
//        int customerIdTodelete = deleteCustomer.getcusId();
//
//        // Check if the coach with the given ID exists
//        boolean cutomerExists = false;
//        for (int i = 0; i < gcus.size(); i++) {
//            Customer existingCustomers = gcus.get(i);
//            if (existingCustomers.getCusId() == customerIdTodelete) {
//                cutomerExists = true;
//                // Update coach properties with the new values
//                gcus.remove(i);
//                System.out.println("Coach Deleted successfully.");
//                break;
//            }
//        }
//
//        if (!cutomerExists) {
//            System.out.println("Coach with ID " + customerIdTodelete + " not found.");
//        }
//
//    }

    //    to be called
    public void showSubscriptionHistory(Customer customer) {
        // Implement logic to display subscription history for a customer
    }

//    to be called
    public void displaySubscriptionsInMonth(int month) {
        // Implement logic to display all customers subscribed in a given month
    }

    public void displayCustomersOfCoach(Coach coach) {
        // Implement logic to display all customers of a specific coach
    }

    public void displayGymIncomeInMonth(int month) {
        // Implement logic to display gym income in a given month
    }

    public void displayCoachesSortedByAssignedCustomers() {
        // Implement logic to display coaches sorted by the most assigned number of customers
        gcoach.sort(Comparator.comparingInt(Coach::getNumberOfTrainee));
        for (Coach coach : gcoach) {
            System.out.println(coach.getName() + ": " + coach.getNumberOfTrainee() + " customers");
        }


    }
}

