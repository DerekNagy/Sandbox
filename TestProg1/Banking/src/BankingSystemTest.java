public class BankingSystemTest {

    public static void main(String[] args) {
        testUserMethods();
        testAuthentication();
    }

    public static void testUserMethods() {
        System.out.println("Testing User methods...");

        // Creating a new user
        User user = new User("john123", "password", 1000.0, 500.0);

        // Testing getter methods
        System.out.println("User ID: " + user.getUserId());
        System.out.println("Checking Balance: $" + user.getCheckingBal());
        System.out.println("Savings Balance: $" + user.getSavingsBal());

        // Testing setter methods
        user.setPassword("newpassword");
        System.out.println("New Password: " + user.getPassword());
        user.setCheckingBal(1500.0);
        user.setSavingsBal(700.0);
        System.out.println("New Checking Balance: $" + user.getCheckingBal());
        System.out.println("New Savings Balance: $" + user.getSavingsBal());

        // Testing withdrawal methods
        user.withdrawFromChecking(200.0);
        user.withdrawFromSavings(100.0);
        System.out.println("Updated Checking Balance after withdrawal: $" + user.getCheckingBal());
        System.out.println("Updated Savings Balance after withdrawal: $" + user.getSavingsBal());

        // Testing deposit methods
        user.depositToChecking(300.0);
        user.depositToSavings(150.0);
        System.out.println("Updated Checking Balance after deposit: $" + user.getCheckingBal());
        System.out.println("Updated Savings Balance after deposit: $" + user.getSavingsBal());

        // Testing transfer methods
        user.transferToSavings(200.0);
        user.transferToChecking(100.0);
        System.out.println("Updated Checking Balance after transfer: $" + user.getCheckingBal());
        System.out.println("Updated Savings Balance after transfer: $" + user.getSavingsBal());
    }

    public static void testAuthentication() {
        System.out.println("\nTesting Authentication...");

        // Creating Authentication instance
        Authentication authentication = new Authentication();

        // Registering a new user
        authentication.registerUser("alice456", "password123", 2000.0, 1000.0);

        // Logging in with registered user credentials
        User loggedInUser = authentication.loginUser();
        if (loggedInUser != null) {
            System.out.println("Logged in as: " + loggedInUser.getUserId());
        }

        // Logging in with invalid credentials
        authentication.loginUser(); // Provide invalid credentials for testing
    }
}
