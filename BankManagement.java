import java.util.ArrayList;
import java.util.Scanner;

class AccountOwner {
	
	static String green = "\u001B[32m";
	static String red = "\u001B[31m";
	static String reset = "\u001B[0m";
	
    protected String name;
    protected String email;
    protected String phoneNumber;
    protected long accountNumber;
    protected double balance;
    protected String password;

    // Getters and setters for each property
	public AccountOwner(String name, String email, String phoneNumber, long accountNumber, double balance, String password)
	{
		this.name=name;
		this.email=email;
		this.phoneNumber=phoneNumber;
		this.accountNumber=accountNumber;
		this.balance=balance;
		this.password=password;
	}
	
	public String getName() {
		return name;
	}
	
	public String getEmail() {
		return email;
	}
	
	public String getPhone() {
		return phoneNumber;
	}
	
	public long getAccountNumber() {
		return accountNumber;
	}
	
	public double getbalance() {
		return balance;
	}
	
	public String getPassword() {
		return password;
	}
	
	public String toString() {
        return "Name: " + name + "\nEmail: " + email + "\nPhone-number: " + phoneNumber + "\nAccount-number: " + accountNumber + "\nBalance: " + "$" + balance;
    }
}

public class BankManagement{

	static Scanner scanner= new Scanner(System.in);
	
	private static ArrayList<AccountOwner> owners =new ArrayList<>();

		static String green = "\u001B[32m";
		static String red = "\u001B[31m";
		static String yellow = "\u001B[33m";
		static String blue = "\u001B[34m";
		static String magenta = "\u001B[35m";
		static String cyan = "\u001B[36m";
		static String reset = "\u001B[0m";
	
	//Main Method
	public static void main(String[] args) {
		
        // Scanner scanner= new Scanner(System.in);
		int choice = 0;
		do {
			System.out.println(red + "-*-*-* WELCOME TO OUR BANK SYSTEM *-*-*-");
			System.out.println(green + "1. Add Account");	
			System.out.println("2. Search Account Data");	
			System.out.println("3. Deposit Money");	
			System.out.println("4. Withdraw Money");	
			System.out.println("5. Check Your Account Balance");	
			System.out.println("6. Check Bank Loans Interest");	
			System.out.println("7. Exit" + reset);	
			System.out.println(red + "*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*\n" + reset);	
			System.out.print("Enter your choice: ");
			choice = scanner.nextInt();
			switch(choice)
			{
				case 1:
					setAccData();
					break;
				case 2:
					searchAccData();
					break;
				case 3:
					depositMoney();
					break;
				case 4:
					withdrawMoney();
					break;
				case 5:
					checkBalance();
					break;
				case 6:
					checkLoanInterest();
					break;
				case 7:
					System.out.println("Exiting program...");
					break;
				default:
					System.out.println("Invalid choice. Please try again.");
			}
		}while (choice != 7);
	}

    // Getters and setters for each property
	private static void setAccData() {
		// Scanner scanner = new Scanner(System.in);
		System.out.println(red + "\n---------------****---------------" + reset);
		System.out.print("Enter your name: ");
		String name = scanner.nextLine();
		System.out.print("Enter your Email: ");
		String email = scanner.nextLine();
		String phoneNumber;
		boolean found = false;
		do {
			System.out.print("Enter your Phonenumber: ");
			phoneNumber = scanner.nextLine();
			if(phoneNumber.length() == 10)
			{
				for(int i=0; i<phoneNumber.length(); i++)
				{
					if(phoneNumber.charAt(i)>='0' && phoneNumber.charAt(i) <= '9')
					{
						found = true;
					}
					else
					{
						found = false;
						System.out.println(red + "Please enter valid Phonenumber." + reset);
						break;
					}
				}
			}
			else
			{
				System.out.println(red + "Please enter 10 digit Phonenumber." + reset);
			}
		}while(found == false);
		System.out.print("Enter Account number: ");
		long accountNumber = scanner.nextLong();
		scanner.nextLine();
		String password;
		boolean flag = false;
		do {
			System.out.print("Enter your Password: ");
			password = scanner.nextLine();
			if(password.length() == 4)
			{
				for(int i=0; i<password.length(); i++)
				{
					if(password.charAt(i)>='0' && password.charAt(i) <= '9')
					{
						flag = true;
					}
					else
					{
						flag = false;
						System.out.println(red + "Please enter valid Password." + reset);
						break;
					}
				}
			}
			else
			{
				System.out.println(red + "Please enter 4 digit Password Pin." + reset);
			}
		}while(flag == false);
		System.out.print("Enter Account balance: ");
		double balance = scanner.nextDouble();
		owners.add(new AccountOwner(name, email, phoneNumber, accountNumber, balance, password));
		System.out.println(red + "---------------****---------------\n" + reset);
	}
	
	private static void searchAccData() {
		// Scanner scanner = new Scanner(System.in);
		System.out.println(red + "\n---------------****---------------" + reset);
		System.out.print("Enter Account number to search: ");
		int search = scanner.nextInt();
		scanner.nextLine();
		boolean found=false;
		int count = 0;
		for(AccountOwner owner : owners) {
			if(owner.getAccountNumber() == search) {
				do {	
					boolean found2 = false;
					System.out.print("Enter Account password: ");
					String password = scanner.nextLine();
					for (AccountOwner owner1 : owners) {
						if(password.equalsIgnoreCase(owner1.getPassword())) {
							System.out.println(red + "\n---------------****---------------" + reset);
							System.out.println(owner);
							System.out.println();
							found2=true;
							found=true;
							count = 4;
							break;
						}
						if(!found2) {
							System.out.println(red + "Incorrect Password. Try again." + reset);
							count++;
							break;
						}
					}
				}while(count <=3);
			}
		}
		if(!found) {
			System.out.println(red + "No Account number found." + reset);
		}
		System.out.println();
    }
	
	

    // Method to add money to the account
    private static void depositMoney() {
		// Scanner scanner = new Scanner(System.in);
		System.out.println(red + "\n---------------****---------------" + reset);
        System.out.print("Enter the Account-number you want to deposit money: ");
        int search = scanner.nextInt();
        boolean found = false;
        for (AccountOwner owner : owners) {
            if (owner.getAccountNumber() == search) {
                System.out.print("Enter amount you want to deposit: ");
				int deposit = scanner.nextInt();
				owner.balance +=deposit;
                found = true;
            }
        }
        if (!found) {
            System.out.println(red + "No account found." + reset);
        }
		System.out.println();
    }

   // Method to remove money from the account
    private static void withdrawMoney() {
        // Scanner scanner = new Scanner(System.in);
		System.out.println(red + "\n---------------****---------------" + reset);
        System.out.print("Enter the Account-number you want to withdraw money: ");
        int search = scanner.nextInt();
		scanner.nextLine();
		int count = 0;
		boolean found = false;
		for(AccountOwner owner : owners) {
			if(owner.getAccountNumber() == search) {
				do {	
					boolean found2 = false;
					System.out.print("Enter Account password: ");
					String password = scanner.nextLine();
					for (AccountOwner owner1 : owners) {
						if(password.equalsIgnoreCase(owner1.getPassword())) {
							System.out.print("Enter amount you want to withdraw: ");
							int withdraw = scanner.nextInt();
							if(owner1.balance > withdraw) {
								owner1.balance -= withdraw;
							}
							else {
								System.out.println(red + "Insufficient Balance.. :<" + reset);
							}
							found2=true;
							found=true;
							count = 4;
							break;
						}
						if(!found2) {
							System.out.println(red + "Incorrect Password. Try again." + reset);
							count++;
							break;
						}
					}
				}while(count <=3);
			}
		}
		if(!found) {
			System.out.println(red + "No account found." + reset);
		}
		System.out.println();
    }

    // Method to check the balance of the account
    public static void checkBalance() {
        // Scanner scanner = new Scanner(System.in);
		System.out.println(red + "\n---------------****---------------" + reset);
		System.out.print("Enter Your Account number: ");
		int search = scanner.nextInt();
		scanner.nextLine();
		boolean found=false;
		int count = 0;
		for(AccountOwner owner : owners) {
			if(owner.getAccountNumber() == search) {
				do {	
					boolean found2 = false;
					System.out.print("Enter Account password: ");
					String password = scanner.nextLine();
					for (AccountOwner owner1 : owners) {
						if(password.equalsIgnoreCase(owner1.getPassword())) {
							System.out.println("Your account balance is: $"+owner1.balance);
							found2=true;
							found=true;
							count = 4;
							break;
						}
						if(!found2) {
							System.out.println(red + "Incorrect Password. Try again." + reset);
							count++;
							break;
						}
					}
				}while(count <=3);
			}
		}
		if(!found) {
			System.out.println(red + "No Account number found." + reset);
		}
		System.out.println();
    }
	
	//Method that provides bank loans interest information
	public static void checkLoanInterest() {
		System.out.println(red + "\n---------------****---------------" + reset);
		System.out.println("Here you can see all loans with their interest rate:\n");
		System.out.println("1. Personal Loan Interest rate: 8.60% ");
		System.out.println("2. Home Loan Interest rate: 8.30%");
		System.out.println("3. Car Loan Interest rate: 18.00%");
		System.out.println("4. Gold Loan Interest rate: 8.80%");
		System.out.println("5. Education Loan Interest rate: 9.37%");
	}
}