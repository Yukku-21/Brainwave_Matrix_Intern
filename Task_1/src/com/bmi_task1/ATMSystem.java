package com.bmi_task1;

import java.util.*;

//ATM Interface 
interface ATMInterface {
	void checkBalance();
	void deposit(double amount);
	void withdraw(double amount);
	void showTransactionHistory();
}

//User Class for Bank Details
class User {
	private final String accountNumber;
	private final String pin;
	private double balance;
	private final List<String> transactionHistory;

	public User(String accountNumber, String pin, double initialBalance) {
		this.accountNumber = accountNumber;
		this.pin = pin;
		this.balance = initialBalance;
		this.transactionHistory = new ArrayList<>();
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public String getPin() {
		return pin;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public List<String> getTransactionHistory() {
		return transactionHistory;
	}

 	public void addTransaction(String transaction) {
 		transactionHistory.add(transaction);
 	}
}

//Implementation class of ATMInterface
class ATMImplementation implements ATMInterface {
	private final User user;

	public ATMImplementation(User user) {
		this.user = user;
	}

	@Override
	public void checkBalance() {
		System.out.printf("Your current balance is: $%.2f%n", user.getBalance());
		user.addTransaction("Checked balance: $" + user.getBalance());
	}

	 @Override
	 public void deposit(double amount) {
	     if (amount > 0) {
	         user.setBalance(user.getBalance() + amount);
	         System.out.printf("Successfully deposited $%.2f. New balance: $%.2f%n", amount, user.getBalance());
	         user.addTransaction("Deposited: $" + amount);
	     } 
	     else {
	         System.out.println("Deposit amount must be greater than zero.");
	     }
	 }

	 @Override
	 public void withdraw(double amount) {
	     if (amount > 0) {
	         if (amount <= user.getBalance()) {
	             user.setBalance(user.getBalance() - amount);
	             System.out.printf("Successfully withdrew $%.2f. New balance: $%.2f%n", amount, user.getBalance());
	             user.addTransaction("Withdrew: $" + amount);
	         }
	         else {
	             System.out.println("Insufficient balance. Transaction failed.");
	         }
	     } 
	     else {
	         System.out.println("Withdrawal amount must be greater than zero.");
	     }
	 }

	 @Override
	 public void showTransactionHistory() {
	     System.out.println("Transaction History:");
	     for (String transaction : user.getTransactionHistory()) {
	         System.out.println(transaction);
	     }
	 }
}

//Main Class ATMSystem
public class ATMSystem {
	private static final Scanner scanner = new Scanner(System.in);
	private static final Map<String, User> users = new HashMap<>();

	 public static void main(String[] args) {
	     users.put("214365", new User("214365", "4321", 500.00));
	     users.put("987654", new User("896745", "6789", 1000.00));
	     users.put("348756", new User("348756", "5445", 2000.00));
	 	
	     System.out.println("Welcome to the ATM System!");
	     User currentUser = authenticateUser();
	
	     if (currentUser != null) {
	         ATMInterface atm = new ATMImplementation(currentUser);
	         boolean exit = false;
	
	         while (!exit) {
	             showMenu();
	             int choice = getUserChoice();
	             switch (choice) {
	                 case 1:
	                     atm.checkBalance();
	                     break;
	                 case 2:
	                     handleDeposit(atm);
	                     break;
	                 case 3:
	                     handleWithdraw(atm);
	                     break;
	                 case 4:
	                     atm.showTransactionHistory();
	                     break;
	                 case 5:
	                     System.out.println("Thank you for using the ATM. Goodbye!");
	                     exit = true;
	                     break;
	                 default:
	                     System.out.println("Invalid choice. Please try again.");
	             }
	         }
	     }
	     else {
	         System.out.println("Authentication failed. Exiting system.");
	     }
	 }
	
	 private static User authenticateUser() {
	     System.out.print("Enter your account number: ");
	     String accountNumber = scanner.nextLine();
	     System.out.print("Enter your PIN: ");
	     String pin = scanner.nextLine();
	
	     User user = users.get(accountNumber);
	     if (user != null && user.getPin().equals(pin)) {
	         System.out.println("Authentication successful!");
	         return user;
	     }
	     else {
	         System.out.println("Invalid account number or PIN.");
	         return null;
	     }
	 }
	
	 private static void showMenu() {
	     System.out.println("\nATM Menu:");
	     System.out.println("1. Check Balance");
	     System.out.println("2. Deposit");
	     System.out.println("3. Withdraw");
	     System.out.println("4. Transaction History");
	     System.out.println("5. Exit");
	     System.out.print("Enter your choice: ");
	 }
	
	 private static int getUserChoice() {
	     while (!scanner.hasNextInt()) {
	         System.out.print("Please enter a valid number: ");
	         scanner.next();
	     }
	     return scanner.nextInt();
	 }
	
	 private static void handleDeposit(ATMInterface atm) {
	     System.out.print("Enter the amount to deposit: ");
	     double amount = getValidAmount();
	     atm.deposit(amount);
	 }
	
	 private static void handleWithdraw(ATMInterface atm) {
	     System.out.print("Enter the amount to withdraw: ");
	     double amount = getValidAmount();
	     atm.withdraw(amount);
	 }
	
	 private static double getValidAmount() {
	     while (!scanner.hasNextDouble()) {
	         System.out.print("Please enter a valid amount: ");
	         scanner.next();
	     }
	     double amount = scanner.nextDouble();
	     if (amount <= 0) {
	         System.out.println("Amount must be greater than zero. Please try again.");
	         return getValidAmount();
	     }
	     return amount;
	 }
}