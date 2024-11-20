package nexwareSolutions.Task3;
	import java.util.Scanner;

	// Class representing the user's Bank Account
	class BankAccount {
	    private double balance;

	    // Constructor
	    public BankAccount(double initialBalance) {
	        if (initialBalance >= 0) {
	            this.balance = initialBalance;
	        } else {
	            System.out.println("Initial balance cannot be negative. Setting balance to $0.");
	            this.balance = 0;
	        }
	    }

	    // Deposit money
	    public String deposit(double amount) {
	        if (amount <= 0) {
	            return "Deposit amount must be greater than zero.";
	        }
	        balance += amount;
	        return "Successfully deposited $" + amount + ". New balance: $" + balance + ".";
	    }

	    // Withdraw money
	    public String withdraw(double amount) {
	        if (amount <= 0) {
	            return "Withdrawal amount must be greater than zero.";
	        }
	        if (amount > balance) {
	            return "Insufficient balance. Current balance: $" + balance + ".";
	        }
	        balance -= amount;
	        return "Successfully withdrew $" + amount + ". New balance: $" + balance + ".";
	    }

	    // Check balance
	    public String checkBalance() {
	        return "Your current balance is: $" + balance;
	    }
	}

	// Class representing the ATM Machine
	class ATM {
	    private BankAccount account;

	    // Constructor
	    public ATM(BankAccount account) {
	        this.account = account;
	    }

	    // Display the ATM menu
	    private void displayMenu() {
	        System.out.println("\n--- ATM MENU ---");
	        System.out.println("1. Check Balance");
	        System.out.println("2. Deposit Money");
	        System.out.println("3. Withdraw Money");
	        System.out.println("4. Exit");
	    }

	    // Run the ATM interface
	    public void run() {
	        Scanner scanner = new Scanner(System.in);
	        boolean exit = false;

	        while (!exit) {
	            displayMenu();
	            System.out.print("Choose an option: ");
	            int choice;

	            // Validate input is an integer
	            if (scanner.hasNextInt()) {
	                choice = scanner.nextInt();
	            } else {
	                System.out.println("Invalid input. Please enter a number.");
	                scanner.next(); // Clear invalid input
	                continue;
	            }

	            switch (choice) {
	                case 1: // Check balance
	                    System.out.println(account.checkBalance());
	                    break;

	                case 2: // Deposit money
	                    System.out.print("Enter deposit amount: ");
	                    if (scanner.hasNextDouble()) {
	                        double depositAmount = scanner.nextDouble();
	                        System.out.println(account.deposit(depositAmount));
	                    } else {
	                        System.out.println("Invalid input. Please enter a valid amount.");
	                        scanner.next(); // Clear invalid input
	                    }
	                    break;

	                case 3: // Withdraw money
	                    System.out.print("Enter withdrawal amount: ");
	                    if (scanner.hasNextDouble()) {
	                        double withdrawAmount = scanner.nextDouble();
	                        System.out.println(account.withdraw(withdrawAmount));
	                    } else {
	                        System.out.println("Invalid input. Please enter a valid amount.");
	                        scanner.next(); // Clear invalid input
	                    }
	                    break;

	                case 4: // Exit
	                    System.out.println("Thank you for using the ATM. Goodbye!");
	                    exit = true;
	                    break;

	                default:
	                    System.out.println("Invalid option. Please select a valid menu option.");
	            }
	        }

	        scanner.close();
	    }
	}

	// Main Class
	public class ATMInterface {
	    public static void main(String[] args) {
	        // Create a BankAccount with an initial balance of $500
	        BankAccount account = new BankAccount(500);

	        // Create an ATM instance linked to the BankAccount
	        ATM atm = new ATM(account);

	        // Run the ATM
	        atm.run();
	    }
	}

