import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class User {
    private String username;
    private String password;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}

public class LoginSystem {
    private static Map<String, User> usersDatabase = new HashMap<>();

    public static void main(String[] args) {
        // Populate users (for demo purposes)
        usersDatabase.put("user1", new User("user1", "password1"));
        usersDatabase.put("user2", new User("user2", "password2"));

        // Get user input
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter username: ");
        String enteredUsername = scanner.nextLine();
        System.out.print("Enter password: ");
        String enteredPassword = scanner.nextLine();

        // Validate login
        if (isValidLogin(enteredUsername, enteredPassword)) {
            System.out.println("Login successful!");
        } else {
            System.out.println("Invalid username or password. Please try again.");
        }

        scanner.close();
    }

    private static boolean isValidLogin(String enteredUsername, String enteredPassword) {
        // Check if the entered username exists
        if (usersDatabase.containsKey(enteredUsername)) {
            // Check if the entered password matches the stored password
            User user = usersDatabase.get(enteredUsername);
            return user.getPassword().equals(enteredPassword);
        }
        return false;
    }
}
