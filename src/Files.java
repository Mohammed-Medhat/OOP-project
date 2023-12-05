import java.io.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Files {

    public static void writeCustomersToFile(String filePath, List<Customer> customers) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filePath))) {
            oos.writeObject(customers);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    public static List<Customer> readCustomersFromFile(String filePath) {
        List<Customer> customers = new ArrayList<>();

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filePath))) {
            customers = (List<Customer>) ois.readObject();
        } catch (FileNotFoundException e) {
            System.err.println("File not found: " + filePath);
            e.printStackTrace();
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Error reading customers from file: " + filePath);
            e.printStackTrace();
        }

        return customers;
    }
}