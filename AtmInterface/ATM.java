package AtmInterface;

import java.util.Scanner;

public class ATM implements ATMInterface {
    private BankAccountInterface account;

    public ATM(BankAccountInterface account) {
        this.account = account;
    }

    @Override
    public void displayMenu() {
        System.out.println("\nWelcome to the ATM!");
        System.out.println("1. Check Balance");
        System.out.println("2. Deposit");
        System.out.println("3. Withdraw");
        System.out.println("4. Exit");
    }

    @Override
    public void start() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            displayMenu();
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    checkBalance();
                    break;
                case 2:
                    deposit();
                    break;
                case 3:
                    withdraw();
                    break;
                case 4:
                    System.out.println("Thank you for using the ATM. Goodbye!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    @Override
    public void checkBalance() {
        System.out.println("Your balance is: Rs. " + account.getBalance());
    }

    @Override
    public void deposit() {
        Scanner s = new Scanner(System.in);
        System.out.print("Enter the deposit amount: Rs. ");
        double amount = s.nextDouble();
        if (amount > 0) {
            account.deposit(amount);
            System.out.println("Deposit successful.");
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    @Override
    public void withdraw() {
        Scanner s = new Scanner(System.in);
        System.out.print("Enter the withdrawal amount: Rs. ");
        double amount = s.nextDouble();
        if (amount > 0) {
            if (account.withdraw(amount)) {
                System.out.println("Withdrawal successful.");
            } else {
                System.out.println("Insufficient balance.");
            }
        } else {
            System.out.println("Invalid withdrawal amount.");
        }
    }
}
