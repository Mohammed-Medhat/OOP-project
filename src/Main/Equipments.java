package Main;

import User.Coach;

import java.io.Serializable;
import java.util.List;
import java.util.Scanner;

public class Equipments implements Serializable {
    protected String name;
    protected int quantity;
    protected static int eqcode;
    private static int Count=0;

    public Equipments(String name, int quantity,List<Equipments> equipmentList) {
        this.name = name;
        this.quantity = quantity;
        Count++;
        eqcode=Count;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getName() {
        return name;
    }

    public static int getEqcode() {
        return eqcode;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static void setCount(int count) {
        Count = count;
    }

    public void setEqcode(int eqcode) {
        this.eqcode = eqcode;
    }

    public static void addEquipmentFromUserInput(List<Equipments> equipmentList) {
        System.out.println("enter the number of euipments you want to add!:   ");
        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();
        Equipments[]equipments=new Equipments[choice];
        for(int i=0 ;i<choice;i++){
            System.out.print("Enter equipment name: ");
            String name = scanner.nextLine();
            System.out.print("Enter equipment quantity: ");
            int quantity = scanner.nextInt();
            equipments[i]=new Equipments(name,quantity,equipmentList);
        }
        scanner.close();
    }


    //for admin only
    public class EquipmentManager {

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
                        equipments[i]=new Equipments(name,quantity,equipmentList);
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
    }


    //for Admin
    public void displayInfo(List<Equipments> equipmentList) {
        for (Equipments equipment : equipmentList)
        {
        System.out.println("\n ******************\n Equipment : " + equipment.getName() + ",\nQuantity: " + equipment.getQuantity()+ "\nCode:  "+ equipment.getEqcode());
    }
    }
    //for costumer
    public void displayName(List<Equipments> equipmentList){
        for (Equipments equipment : equipmentList)
        {
            System.out.println("\n ******************\n Equipment : " + equipment.getName());
        }
    }

}
