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
        transactionHistory.add("Deposited: $" + amount);
    }

    public void withdraw(double amount) {
        if (balance >= amount) {
            balance -= amount;
            transactionHistory.add("Withdrew: $" + amount);
        } else {
            System.out.println("Insufficient funds.");
        }
    }

    public void transfer(User recipient, double amount) {
        if (balance >= amount) {
            balance -= amount;
            recipient.deposit(amount);
            transactionHistory.add("Transferred to " + recipient.name + ": $" + amount);
            recipient.transactionHistory.add("Received from " + name + ": $" + amount);
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
}

public class Task_1_Online_Banking_System {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        User user1 = new User("Alice", 12345, 1000);
        User user2 = new User("Bob", 67890, 500);

        // Start the banking system
        System.out.println("Welcome to the Online Banking System!");

        // Implement a loop for continuous user interaction and menu-based operations
        while (true) {
            // Display options for users to choose from
            // Handle user input for actions (deposit, withdraw, transfer, check balance, view history, etc.)
        }
    }
}
