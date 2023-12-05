import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        String filePath = "C:\\Users\\iShop\\IdeaProjects\\OOP project\\Customer.txt";
        List<Customer> readCustomers = Files.readCustomersFromFile(filePath);

readCustomers.add(new Customer(15,"lol",'F',"d",051654,"ff"));




                Customer firstCustomer = readCustomers.get(2);
                System.out.println("Information of the first customer:");
                System.out.println("Name: " + firstCustomer.getName());


                System.out.println("Age: " + firstCustomer.getId());


        Files.writeCustomersToFile(filePath, readCustomers);
        }

}



