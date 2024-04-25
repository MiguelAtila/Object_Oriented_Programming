package calcu;

import java.math.BigInteger;
import java.math.BigDecimal;
import java.util.Scanner;

public class BinaryCalculator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. Add binary numbers");
            System.out.println("2. Subtract binary numbers");
            System.out.println("3. Convert decimal number to binary");
            System.out.println("4. Get hexadecimal and octal representation");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int option = scanner.nextInt();

            switch (option) {
                case 1:
                    addBinaries();
                    break;
                case 2:
                    subtractBinaries();
                    break;
                case 3:
                    decimalToBinary();
                    break;
                case 4:
                    getHexOct();
                    break;
                case 5:
                    System.out.println("Exiting...");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid option. Please enter a number from 1 to 5.");
            }
        }
    }

    public static void addBinaries() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the first binary number:");
        String num1 = scanner.nextLine();
        System.out.println("Enter the second binary number:");
        String num2 = scanner.nextLine();

        // Convert binary numbers to BigIntegers
        BigInteger bi1 = new BigInteger(num1, 2);
        BigInteger bi2 = new BigInteger(num2, 2);

        // Add the binary numbers
        BigInteger result = bi1.add(bi2);

        // Display the result in binary
        System.out.println("The sum is: " + result.toString(2));
    }

    public static void subtractBinaries() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the first binary number (minuend):");
        String num1 = scanner.nextLine();
        System.out.println("Enter the second binary number (subtrahend):");
        String num2 = scanner.nextLine();

        // Convert binary numbers to BigIntegers
        BigInteger bi1 = new BigInteger(num1, 2);
        BigInteger bi2 = new BigInteger(num2, 2);

        // Subtract the binary numbers
        BigInteger result = bi1.subtract(bi2);

        // Display the result in binary
        System.out.println("The difference is: " + result.toString(2));
    }

    public static void decimalToBinary() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the decimal number:");
        BigDecimal decimalNum = scanner.nextBigDecimal();

        // Convert the decimal number to binary
        String binary = decimalNum.toBigInteger().toString(2);

        // Display the result in binary
        System.out.println("The number " + decimalNum + " in binary is: " + binary);
    }

    public static void getHexOct() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the decimal number:");
        BigDecimal decimalNum = scanner.nextBigDecimal();

        // Get the hexadecimal and octal representation
        String hexadecimal = decimalNum.toBigInteger().toString(16);
        String octal = decimalNum.toBigInteger().toString(8);

        // Display the result in hexadecimal and octal
        System.out.println("The number " + decimalNum + " in hexadecimal is: " + hexadecimal);
        System.out.println("The number " + decimalNum + " in octal is: " + octal);
    }
}


