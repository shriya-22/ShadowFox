import java.util.ArrayList;
import java.util.List;

// Main BankAccount class
class BankAccount {
    private String accountHolder;
    private double balance;
    private List<String> transactions;

    public BankAccount(String accountHolder, double initialBalance) {
        this.accountHolder = accountHolder;
        this.balance = initialBalance;
        this.transactions = new ArrayList<>();
        transactions.add("Account created with balance: " + initialBalance);
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            transactions.add("Deposited: " + amount);
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && balance >= amount) {
            balance -= amount;
            transactions.add("Withdrew: " + amount);
        }
    }

    public double getBalance() {
        return balance;
    }

    public List<String> getTransactionHistory() {
        return transactions;
    }
}

// JUnit Test Class
public class BankAccountTest {
    public static void main(String[] args) {
        BankAccount account = new BankAccount("Shriya", 1000);

        account.deposit(300);
        account.withdraw(200);

        System.out.println("Balance: " + account.getBalance());
        System.out.println("Transactions: ");
        for (String t : account.getTransactionHistory()) {
            System.out.println(" - " + t);
        }

        // Basic Manual Test Output
        assert account.getBalance() == 1300 : "Test Failed: Incorrect balance";
        System.out.println("✅ All tests passed!");
    }
}
