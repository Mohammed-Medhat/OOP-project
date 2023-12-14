package System;

import User.Coach;
import User.Customer;

import java.io.*;
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

    public static void writeCoachToFile(String filePath, List<Coach> coaches) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filePath))) {
            oos.writeObject(coaches);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<Coach> readCoachFromFile(String filePath) {
        List<Coach> coaches = new ArrayList<>();

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filePath))) {
            coaches = (List<Coach>) ois.readObject();
        } catch (FileNotFoundException e) {
            System.err.println("File not found: " + filePath);
            e.printStackTrace();
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Error reading coaches from file: " + filePath);
            e.printStackTrace();
        }

        return coaches;
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
