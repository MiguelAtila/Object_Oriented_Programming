package Main;

import EstructureOffice.*;
import EstructureOffice.Package;
import exception.UserException;

import java.util.Scanner;

public class MailSystem {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            try {
                System.out.println("Select the type of shipment:");
                System.out.println("1. Letter");
                System.out.println("2. Package");
                System.out.println("3. Exit");
                int choice = scanner.nextInt();
                scanner.nextLine(); // Consume new line

                if (choice == 3) {
                    break;
                }

                System.out.println("Enter sender details:");
                User sender = createUser(scanner);

                System.out.println("Enter recipient details:");
                User recipient = createUser(scanner);

                if (choice == 1) {
                    Letter letter = new Letter(sender, recipient);
                    Distribution destination = getDistributionPoint(sender.getAddress());
                    printEstimateDetails(letter, destination);
                } else if (choice == 2) {
                    System.out.println("Enter the package weight (kg):");
                    double weight = scanner.nextDouble();
                    scanner.nextLine(); // Consume new line
                    System.out.println("Enter the description of the content:");
                    String description = scanner.nextLine();

                    Item mailItem = new Item(sender, recipient, weight, description);
                    Distribution destination = getDistributionPoint(sender.getAddress());

                    printEstimateDetails(mailItem, destination);
                }
            } catch (UserException e) {
                System.out.println(e.getMessage());
            } catch (Exception e) {
                System.out.println("An error occurred: " + e.getMessage());
            }
        }

        scanner.close();
    }

    private static User createUser(Scanner scanner) throws UserException {
        System.out.println("Full name:");
        String fullName = scanner.nextLine();
        System.out.println("Address (format: 'Street Number, Neighborhood, City, Postal Code, State Alias'):");
        String address = scanner.nextLine();
        System.out.println("Phone number:");
        String phoneNumber = scanner.nextLine();
        System.out.println("Email:");
        String email = scanner.nextLine();

        return new User(fullName, address, phoneNumber, email);
    }

    private static Distribution getDistributionPoint(String address) throws UserException {
        String[] addressParts = address.split(",");
        if (addressParts.length < 5) {
            throw new UserException("Invalid address format. Please follow the format: 'Street Number, Neighborhood, City, Postal Code, State Alias'");
        }

        String postalCode = addressParts[3].trim();
        String stateAlias = addressParts[4].trim();

        // Verificar código postal y alias del estado en una sola línea
        if (!postalCode.matches("\\d{5}") || !stateAlias.matches("OAX|QROO|MOR|QRO|SIN")) {
            throw new UserException("Invalid postal code or state alias. The postal code must be 5 digits and the state alias must be one of: OAX, QROO, MOR, QRO, SIN");
        }

        try {
            return Distribution.valueOf(stateAlias);  // Utiliza el método estático valueOf para obtener la instancia de Distribution
        } catch (IllegalArgumentException e) {
            throw new UserException("Invalid state alias. Allowed values are: OAX, QROO, MOR, QRO, SIN");
        }
    }

    private static void printEstimateDetails(Package pkg, Distribution destination) {
        System.out.println("Estimated price: " + pkg.estimatePrice(destination));
        System.out.println("Estimated arrival time: " + pkg.getEstimateArrival(destination));
    }
}
