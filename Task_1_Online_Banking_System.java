import java.util.ArrayList;
import java.util.Scanner;

class User {
    private String name;
    private int accountNumber;
    private double balance;
    private ArrayList<String> transactionHistory;

    // Constructor
    public User(String name, int accountNumber, double balance) {
        this.name = name;
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.transactionHistory = new ArrayList<>();
    }

    // Methods for banking operations
    public void deposit(double amount) {
        balance += amount;
        transactionHistory.add("Deposited: Rs" + amount);
    }

    public void withdraw(double amount) {
        if (balance >= amount) {
            balance -= amount;
            transactionHistory.add("Withdrew: Rs" + amount);
        } else {
            System.out.println("Insufficient funds.");
        }
    }

    public void transfer(User recipient, double amount) {
        if (balance >= amount) {
            balance -= amount;
            recipient.deposit(amount);
            transactionHistory.add("Transferred to " + recipient.name + ": Rs" + amount);
            recipient.transactionHistory.add("Received from " + name + ": Rs" + amount);
        } else {
            System.out.println("Insufficient funds.");
        }
    }

    public double getBalance() {
        return balance;
    }

    public void printTransactionHistory() {
        for (String transaction : transactionHistory) {
            System.out.println(transaction);
        }
    }

    public void checkAccountDetails() {
        System.out.println("Account Details for " + name);
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Balance: Rs " + balance);
    }

    public void changeUserInformation(String newName) {
        name = newName;
        System.out.println("User information updated successfully.");
    }
}

public class Task_1_Online_Banking_System {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        User user1 = new User("Bhushan Lilhare", 12345, 1000);
        User user2 = new User("Vaibhav Nagfase", 67890, 500);

        // Start the banking system
        System.out.println("Welcome to the Online Banking System!");

        // Implement a loop for continuous user interaction and menu-based operations
        while (true) {
            // Display options for users to choose from
            System.out.println("\nOptions:");
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Transfer");
            System.out.println("4. Check Balance");
            System.out.println("5. View Transaction History");
            System.out.println("6. Check Account Details");
            System.out.println("7. Change User Information");
            System.out.println("8. Exit");

            // Handle user input for actions
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter deposit amount: Rs");
                    double depositAmount = scanner.nextDouble();
                    user1.deposit(depositAmount);
                    break;
                case 2:
                    System.out.print("Enter withdrawal amount: Rs");
                    double withdrawalAmount = scanner.nextDouble();
                    user1.withdraw(withdrawalAmount);
                    break;
                case 3:
                    System.out.print("Enter transfer amount: Rs");
                    double transferAmount = scanner.nextDouble();
                    System.out.print("Enter recipient's account number: ");
                    int recipientAccountNumber = scanner.nextInt();
                    // Assuming user2 is the recipient for demonstration purposes
                    user1.transfer(user2, transferAmount);
                    break;
                case 4:
                    System.out.println("Balance: Rs " + user1.getBalance());
                    break;
                case 5:
                    user1.printTransactionHistory();
                    break;
                case 6:
                    user1.checkAccountDetails();
                    break;
                case 7:
                    System.out.print("Enter new name: ");
                    String newName = scanner.next();
                    user1.changeUserInformation(newName);
                    break;
                case 8:
                    System.out.println("Exiting the Online Banking System. Goodbye!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please choose a valid option.");
            }
        }
    }
}
