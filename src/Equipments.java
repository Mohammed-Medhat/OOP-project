import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Equipments {
    protected String name;
    protected int quantity;
    protected int eqcode;
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

    public int getEqcode() {
        return eqcode;
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