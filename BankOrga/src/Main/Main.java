package Main;

import Account.*;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Enter name: ");
            String name = scanner.nextLine();

            System.out.print("Enter email: ");
            String email = scanner.nextLine();

            System.out.print("Enter phone number: ");
            String phoneNumber = scanner.nextLine();

            System.out.print("Enter initial balance: ");
            double initialBalance = getDoubleInput(scanner);

            System.out.print("Choose account type (1: Personal, 2: Savings, 3: Business): ");
            int accountType = getIntInput(scanner);

            AbstractAccount account;
            switch (accountType) {
                case 1:
                    account = new PersonalAccount();
                    break;
                case 2:
                    account = new SavingsAccount();
                    break;
                case 3:
                    account = new BusinessAccount();
                    break;
                default:
                    throw new AccountCreationException("Invalid account type.");
            }

            account.createAccount(name, email, phoneNumber, initialBalance);
            System.out.println("Account created successfully: ");
            System.out.println(account);

        } catch (AccountCreationException e) {
            System.err.println("Account creation failed: " + e.getMessage());
        } catch (AccountException e) {
            System.err.println("Account creation failed: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("An unexpected error occurred: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }

    private static int getIntInput(Scanner scanner) {
        while (true) {
            try {
                return Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.print("Invalid input. Please enter a valid number: ");
            }
        }
    }

    private static double getDoubleInput(Scanner scanner) {
        while (true) {
            try {
                return Double.parseDouble(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.print("Invalid input. Please enter a valid number: ");
            }
        }
    }
}
