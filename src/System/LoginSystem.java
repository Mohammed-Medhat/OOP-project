package System;

import User.Customer;

import java.util.List;

public class LoginSystem {

    static boolean login(List<Customer> customerList, String username, String password) {
        // Search for the customer in the list
        for (Customer customer : customerList) {
            if (customer.getEmail().equals(username) && customer.getPassword().equals(password)) {
                return true; // Login successful
            }
        }
        return false; // Login failed
    }
}
