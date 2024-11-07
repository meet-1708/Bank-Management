import java.util.ArrayList;

class AccountOwner {
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;

    // Constructor
    public AccountOwner(String firstName, String lastName, String email, String phoneNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    // Getters and setters for each property
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}

public class BankAccount {
    private String accountNumber;
    private double balance;
    private double overdraftLimit;
    private ArrayList<AccountOwner> owners;

    // Constructor
    public BankAccount(String accountNumber, double balance, double overdraftLimit, ArrayList<AccountOwner> owners) {
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.overdraftLimit = overdraftLimit;
        this.owners = owners;
    }

    // Getters and setters for each property
    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getOverdraftLimit() {
        return overdraftLimit;
    }

    public void setOverdraftLimit(double overdraftLimit) {
        this.overdraftLimit = overdraftLimit;
    }

    public ArrayList<AccountOwner> getOwners() {
        return owners;
    }

    public void setOwners(ArrayList<AccountOwner> owners) {
        this.owners = owners;
    }

    // Method to add money to the account
    public void deposit(double amount) {
        balance += amount;
    }

    // Method to remove money from the account
    public void withdraw(double amount) {
        if (balance - amount < -overdraftLimit) {
            System.out.println("Insufficient funds!");
        } else {
            balance -= amount;
        }
    }

    // Method to check the balance of the account
    public void checkBalance() {
        System.out.println("Current balance: " + balance);
    }
}
