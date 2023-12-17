package User;
import static User.Coach.addcoach;
import static User.Coach.getCoId;
import System.Equipments;
import  static System.Equipments.addEquipmentFromUserInput;
import java.io.Serializable;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import static System.Gym.gequipment;
import static System.Gym.gcoach;
import static System.Gym.gcus;
import static User.Customer.iscustExists;

public class Admin extends Person implements Serializable {

    public Admin() {


    }
    public Admin(String name, char gender, String address, String phoneNumber) {
        super(name, gender, address, phoneNumber, "Admin", "Admin");

    }

    @Override
    void displayDetails() {

    }

    // Additional admin-specific methods
    public boolean isIdExists(int id, List<Coach> existingCoaches) {
        // Check if the ID already exists in the list of coaches
        for (Coach coach : existingCoaches) {
            if (Coach.getCoId() == id) {
                return true; // ID already exists
            }
        }
        return false; // ID is unique
    }

    public void addCoach(int id) {
        for(Coach c:gcoach){
            if(c.getCoId()==id){
                System.out.println("Coach with the same ID already exists. Please choose a different ID.");




            }
            else{
                c.addcoach();
                System.out.println("Coach added successfully.");
                break;
            }
        }
        // Check if the coach ID already exists


    }


    public void editCoach(Coach updatedCoach) {
        int coachIdToUpdate = Coach.getCoId();

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
        int coachIdTodelete = Coach.getCoId();

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
    public static void deleteEquipment(List<Equipments> equipmentList) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the name of the equipment you want to delete: ");
        String targetName = scanner.nextLine();

        Equipments targetEquipment = null;

        // Find the equipment to delete
        for (Equipments equipment : equipmentList) {
            if (equipment.getName().equals(targetName)) {
                targetEquipment = equipment;
                break;
            }
        }

        if (targetEquipment == null) {
            System.out.println("Equipment not found!");
        } else {
            equipmentList.remove(targetEquipment);
            System.out.println("Equipment deleted successfully!");
        }

        scanner.close();
}

//    equipments to be called
public static void editOrDeleteEquipment(List<Equipments> equipmentList) {
    Scanner scanner = new Scanner(System.in);

    System.out.println("Enter the name of the equipment you want to edit or delete: ");
    String targetName = scanner.nextLine();

    Equipments targetEquipment = null;

    // Find the equipment to edit or delete
    for (Equipments equipment : equipmentList) {
        if (equipment.getName().equals(targetName)) {
            targetEquipment = equipment;
            break;
        }
    }

    if (targetEquipment == null) {
        System.out.println("Equipment not found!");
        scanner.close();
        return;
    }

    System.out.println("Choose an action:");
    System.out.println("1. add Equiment?");
    System.out.println("2. Edit Equipment?");
    System.out.println("3. Delete Equipment?");
    int actionChoice = scanner.nextInt();
    scanner.nextLine();

    switch (actionChoice) {
        case 1:
            System.out.println("enter the number of euipments you want to add!:   ");
            int choice = scanner.nextInt();
            Equipments[]equipments=new Equipments[choice];
            for(int i=0 ;i<choice;i++){
                System.out.print("Enter equipment name: ");
                String name = scanner.nextLine();
                System.out.print("Enter equipment quantity: ");
                int quantity = scanner.nextInt();
                equipments[i]=new Equipments(name,quantity);
            }
            scanner.close();

        case 2:
            for (Equipments equipment : equipmentList)
            {
                System.out.println("\n ******************\n Equipment : " + equipment.getName() + ",\nQuantity: " + equipment.getQuantity()+ "\nCode:  "+ equipment.getEqcode());
            }
            editEquipment(targetEquipment);
            System.out.println("Equipment details updated successfully!");
            break;
        case 3:
            equipmentList.remove(targetEquipment);
            System.out.println("Equipment deleted successfully!");
            break;
        default:
            System.out.println("Invalid choice. No changes made.");
    }

    scanner.close();
}
    private boolean EQidexist(int eqcode,List<Equipments> equipmentList) {
        // Check if the ID already exists in the list of coaches
        for (Equipments EQ : equipmentList) {
            if (  Equipments.getEqcode() == eqcode) {
                return true; // ID already exists
            }
        }
        return false; // ID is unique
    }

    private static void editEquipment(Equipments equipment) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter equipment name (press Enter to keep it unchanged): ");
        String newName = scanner.nextLine();
        if (!newName.isEmpty()) {
            equipment.setName(newName);
        }

        System.out.print("Enter new equipment quantity (press Enter to keep it unchanged): ");
        String newQuantityStr = scanner.nextLine();
        if (!newQuantityStr.isEmpty()) {
            try {
                int newQuantity = Integer.parseInt(newQuantityStr);
                equipment.setQuantity(newQuantity);
            } catch (NumberFormatException e) {
                System.out.println("Invalid quantity format. Quantity remains unchanged.");
            }
        }

        scanner.close();
    }

    public void addCus(Customer cus) {
        // Check if the customer ID already exists
        if (!iscustExists(Customer.getCusId())) {
            gcus.add(cus);
            System.out.println("Customer added successfully.");
        } else {
            System.out.println("Customer with the same ID already exists. Please choose a different ID.");
        }
    }


        public void editCustomer(Customer updatedCustomer) {
            int customerIdToUpdate = Customer.getCusId();

            // Check if the coach with the given ID exists
            boolean cutomerExists = false;
            for (Customer existingCustomers : gcus) {
                if (Customer.getCusId() == customerIdToUpdate) {
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


    public void deleteCustomer(Customer customer) {
        // Implement customer deletion logic
        int customerIdTodelete = Customer.getCusId();

        // Check if the coach with the given ID exists
        boolean cutomerExists = false;
        for (int i = 0; i < gcus.size(); i++) {
            Customer existingCustomers = gcus.get(i);
            if (Customer.getCusId() == customerIdTodelete) {
                cutomerExists = true;
                // Update coach properties with the new values
                gcus.remove(i);
                System.out.println("Coach Deleted successfully.");
                break;
            }
        }

        if (!cutomerExists) {
            System.out.println("Coach with ID " + customerIdTodelete + " not found.");
        }

    }

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
    public void addEntity() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Choose an entity to add:");
        System.out.println("1. Coach");
        System.out.println("2. Customer");
        System.out.println("3. Equipment");

        int entityChoice = scanner.nextInt();
        scanner.nextLine();  // Consume the newline character

        switch (entityChoice) {
            case 1:
                addCoach(scanner.nextInt());
                break;
            case 2:
                Customer.createSampleCustomer();

                break;
            case 3:
               addEquipmentFromUserInput();
                break;
            default:
                System.out.println("Invalid choice. No entity added.");
        }


    }

    public void editEntity() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Choose an entity to edit:");
        System.out.println("1. Coach");
        System.out.println("2. Customer");
        System.out.println("3. Equipment");

        int entityChoice = scanner.nextInt();
        scanner.nextLine();  // Consume the newline character

        switch (entityChoice) {
            case 1:
                System.out.println("enter coach id");
                int coach_id=scanner.nextInt();
                scanner.nextLine();
                for(int i=0;i<gcoach.size();i++){
                    if(gcoach.get(i).getCoId()==coach_id){
                        editCoach(gcoach.get(i));
                    }
                }
                break;
            case 2:
                System.out.println("enter customer id");
                int customer_id=scanner.nextInt();
                scanner.nextLine();
                for(int i=0;i<gcus.size();i++){
                    if(gcus.get(i).getCusId()==customer_id){
                        editCustomer(gcus.get(i));
                    }
                }

                break;
            case 3:
                System.out.println("enter Equipment id");
                int Equpment_code=scanner.nextInt();
                scanner.nextLine();
                for(int i=0;i<gequipment.size();i++){
                    if(gequipment.get(i).getEqcode()==Equpment_code){
                        editEquipment(gequipment.get(i));
                    }
                }
                break;
            default:
                System.out.println("Invalid choice. No entity edited.");
        }


    }

    public void deleteEntity() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Choose an entity to delete:");
        System.out.println("1. Coach");
        System.out.println("2. Customer");
        System.out.println("3. Equipment");

        int entityChoice = scanner.nextInt();
        scanner.nextLine();  // Consume the newline character

        switch (entityChoice) {
            case 1:
                System.out.println("enter coach id to delete");
                int coach_id=scanner.nextInt();
                scanner.nextLine();
                for(int i=0;i<gcoach.size();i++){
                    if(gcoach.get(i).getCoId()==coach_id){
                        deleteCoach(gcoach.get(i));
                    }
                }

                break;
            case 2:
                System.out.println("enter customer id");
                int customer_id=scanner.nextInt();
                scanner.nextLine();
                for(int i=0;i<gcus.size();i++){
                    if(gcus.get(i).getCusId()==customer_id){
                        deleteCustomer(gcus.get(i));
                    }
                }
                break;
            case 3:
                deleteEquipment(gequipment);
                break;
            default:
                System.out.println("Invalid choice. No entity deleted.");
        }


    }
    public int login(String username, String password) {

            if ("Admin".equals(username) && "Admin".equals(password)) {

                return 1;

            }

        return -1;
    }

    @Override
    public void signup(String email) {

    }


}

