import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Authentication {
    private Map<String, User> users;
    private Scanner scanner;

    public Authentication() {
        users = new HashMap<>();
        scanner = new Scanner(System.in);
    }

    public void registerUser(String userId, String password, double checkingBal, double savingsBal) {
        if (users.containsKey(userId)) {
            System.out.println("User with this ID already exists. Please choose a different ID.");
        } else {
            User user = new User(userId, password, checkingBal, savingsBal);
            users.put(userId, user);
            System.out.println("User registered successfully.");
        }
    }

    public User loginUser() {
        System.out.println("Enter your user ID:");
        String userId = scanner.nextLine();
        System.out.println("Enter your password:");
        String password = scanner.nextLine();

        User user = users.get(userId);
        if (user != null && user.getPassword().equals(password)) {
            System.out.println("Login successful!");
            return user;
        } else {
            System.out.println("Invalid user ID or password. Please try again.");
            return null;
        }
    }
}
