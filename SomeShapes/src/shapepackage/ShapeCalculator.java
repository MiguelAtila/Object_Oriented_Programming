package shapepackage;
import java.util.Scanner;

public class ShapeCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Select the geometric figure you want to create:");
            System.out.println("1. Circle");
            System.out.println("2. Ellipse");
            System.out.println("3. Triangle");
            System.out.println("4. Rectangle");
            System.out.println("5. Square");
            System.out.println("6. Exit");

            int choice = scanner.nextInt();

            if (choice == 6) {
                break;
            }

            Shape shape = null; // Initialize shape variable

            switch (choice) {
                case 1:
                    System.out.println("Enter the radius of the circle:");
                    double radius = scanner.nextDouble();
                    shape = new Circle(radius); // Declare shape as Circle
                    break;
                case 2:
                    System.out.println("Enter the major axis of the ellipse:");
                    double majorAxis = scanner.nextDouble();
                    System.out.println("Enter the minor axis of the ellipse:");
                    double minorAxis = scanner.nextDouble();
                    shape = new Ellipse(majorAxis, minorAxis); // Declare shape as Ellipse
                    break;
                case 3:
                    System.out.println("Enter side A of the triangle:");
                    double sideA = scanner.nextDouble();
                    System.out.println("Enter side B of the triangle:");
                    double sideB = scanner.nextDouble();
                    System.out.println("Enter side C of the triangle:");
                    double sideC = scanner.nextDouble();
                    shape = new Triangle(sideA, sideB, sideC); // Declare shape as Triangle
                    break;
                case 4:
                    System.out.println("Enter the length of the rectangle:");
                    double length = scanner.nextDouble();
                    System.out.println("Enter the width of the rectangle:");
                    double width = scanner.nextDouble();
                    shape = new Rectangle(length, width); // Declare shape as Rectangle
                    break;
                case 5:
                    System.out.println("Enter the side of the square:");
                    double side = scanner.nextDouble();
                    shape = new Square(side); // Declare shape as Square
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
                    continue;
            }

            if (shape != null) {
                System.out.println("Area: " + shape.getArea());
                System.out.println("Perimeter: " + shape.getPerimeter());
            }
        }

        scanner.close();
    }
}
