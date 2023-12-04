
import java.util.ArrayList;
import java.util.List;

public class Equipments {
        protected String name;
        protected int quantity;
    public List<Equipments> equipmentList;
        public Equipments(){

        }
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

    protected void displayInfo() {
    }
}
