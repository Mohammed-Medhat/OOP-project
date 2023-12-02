
public class Equipments {
        protected String name;
        protected int quantity;
        public Equipments(){

        }
        public Equipments(String name, int quantity) {
            this.name = name;
            this.quantity = quantity;
        }

        public String getName() {
            return name;
        }

        public int getQuantity() {
            return quantity;
        }

        public void displayInfo() {
            System.out.println("Equipment: " + name + ", Quantity: " + quantity);
        }
    }
