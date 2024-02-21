import java.util.Scanner;

public class User {
    private String userId;
    private String password;
    private double checkingBal;
    private double savingsBal;
    private Scanner scanner;

    public User(String id, String pass, double checkbal, double savbal) {
        userId = id;
        password = pass;
        checkingBal = checkbal;
        savingsBal = savbal;
        scanner = new Scanner(System.in);
    }

    public User(String id, String pass) {
        this(id, pass, 0, 0);
    }

    public User(String id, String pass, double checkbal) {
        this(id, pass, checkbal, 0);
    }

    // Getters and Setters
    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String newPassword) {
        if (newPassword.equals(password)) {
            System.out.println("This is your current password!");
        } else {
            System.out.println("Your old password is: " + password);
            System.out.println("Your new password is: " + newPassword);
            System.out.println("Confirm this change by typing in your new password again!");

            String confirmation = scanner.nextLine();
            if (confirmation.equals(newPassword)) {
                password = newPassword;
                System.out.println("Your password was successfully changed!");
            } else {
                System.out.println("The password change was unsuccessful. Please try again.");
            }
        }
    }

    public double getCheckingBal() {
        return checkingBal;
    }

    public void setCheckingBal(double checkingBal) {
        this.checkingBal = checkingBal;
    }

    public double getSavingsBal() {
        return savingsBal;
    }

    public void setSavingsBal(double savingsBal) {
        this.savingsBal = savingsBal;
    }

    // Deposit and Withdraw methods
    public void depositToChecking(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Deposit amount must be positive.");
        }
        checkingBal += amount;
    }

    public void withdrawFromChecking(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Withdrawal amount must be positive.");
        }
        if (amount > checkingBal) {
            System.out.println("Insufficient funds in checking account.");
        } else {
            System.out.println("Please confirm your password to withdraw $" + amount + " from your checking account:");
            String inputPassword = scanner.nextLine();
            if (inputPassword.equals(password)) {
                checkingBal -= amount;
                System.out.println("Withdrawal successful! Your new balance is $" + checkingBal);
            } else {
                System.out.println("Password authentication failed. Withdrawal aborted.");
            }
        }
    }

    public void depositToSavings(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Deposit amount must be positive.");
        }
        savingsBal += amount;
    }

    public void withdrawFromSavings(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Withdrawal amount must be positive.");
        }
        if (amount > savingsBal) {
            System.out.println("Insufficient funds in savings account.");
        } else {
            System.out.println("Please confirm your password to withdraw $" + amount + " from your savings account:");
            String inputPassword = scanner.nextLine();
            if (inputPassword.equals(password)) {
                savingsBal -= amount;
                System.out.println("Withdrawal successful! Your new balance is $" + savingsBal);
            } else {
                System.out.println("Password authentication failed. Withdrawal aborted.");
            }
        }
    }

    // Transfer methods
    public void transferToChecking(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Transfer amount must be positive.");
        }
        if (amount > savingsBal) {
            throw new IllegalArgumentException("Insufficient funds in savings account.");
        }
        savingsBal -= amount;
        checkingBal += amount;
    }

    public void transferToSavings(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Transfer amount must be positive.");
        }
        if (amount > checkingBal) {
            throw new IllegalArgumentException("Insufficient funds in checking account.");
        }
        checkingBal -= amount;
        savingsBal += amount;
    }
}
