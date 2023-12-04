import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Equipments {
    protected String name;
    protected int quantity;


    public Equipments(String name, int quantity) {
        this.name = name;
        this.quantity = quantity;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getName() {
        return name;
    }



    public void addEquipmentFromUserInput(List<Equipments> equipmentList) {
        System.out.println("enter the number of euipments you want to add!:   ");
        Scanner scanner = new Scanner(System.in);
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
    }
    protected void displayInfo(List<Equipments> equipmentList) {
        for (Equipments equipment : equipmentList)
        {
        System.out.println("\n ******************\n Equipment: " + equipment.getName() + ",\nQuantity: " + equipment.getQuantity());
    }
    }

}