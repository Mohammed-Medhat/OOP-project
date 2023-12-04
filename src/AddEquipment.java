import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class AddEquipment extends Equipments {
    public List<Equipments> equipmentList;

    public AddEquipment() {
        this.equipmentList = new ArrayList<>();
    }

    public void addEquipment(String name, int quantity) {
        Equipments equipments = new Equipments(name, quantity);
        equipmentList.add(equipments);
    }

    public void addEquipmentFromUserInput() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter equipment name: ");
        String name = scanner.nextLine();

        System.out.print("Enter equipment quantity: ");
        int quantity = scanner.nextInt();

        Equipments equipment = new Equipments(name, quantity);
        equipmentList.add(equipment);
    }

    public void displayInfo() {
        for (Equipments equipment : equipmentList) {
            System.out.println("Equipment: " + equipment.getName() + ", Quantity: " + equipment.getQuantity());
        }
    }


}
