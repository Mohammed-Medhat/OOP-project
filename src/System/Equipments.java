package System;
import static System.Gym.gequipment;
import java.io.Serializable;
import java.util.List;
import java.util.Scanner;

public class Equipments implements Serializable {
    protected String name;
    protected int quantity;
    protected static int eqcode;
    private static int Count=0;

    public Equipments(String name, int quantity) {
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

    public static void addEquipmentFromUserInput() {
        System.out.println("enter the number of euipments you want to add!:   ");
        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();
        scanner.nextLine();
        Equipments[]equipments=new Equipments[choice];
        for(int i=0 ;i<choice;i++){
            System.out.print("Enter equipment name: ");
            String name = scanner.nextLine();
            System.out.print("Enter equipment quantity: ");
            int quantity = scanner.nextInt();
            scanner.nextLine();
            equipments[i]=new Equipments(name,quantity);
            gequipment.add(equipments[i]);

        }

    }


    //for admin only



        //for Admin
        public void displayInfo(List<Equipments> equipmentList) {
            for (Equipments equipment : equipmentList) {
                System.out.println("\n ******************\n Equipment : " + equipment.getName() + ",\nQuantity: " + equipment.getQuantity() + "\nCode:  " + equipment.getEqcode());
            }
        }

        //for costumer
        public void displayName(List<Equipments> equipmentList) {
            for (Equipments equipment : equipmentList) {
                System.out.println("\n ******************\n Equipment : " + equipment.getName());
            }
        }

}
