package shapes;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Choose a shape:");
            System.out.println("1. Circle");
            System.out.println("2. Ellipse");
            System.out.println("3. Triangle");
            System.out.println("4. Rectangle");
            System.out.println("5. Square");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            double area, perimeter;

            switch (choice) {
                case 1:
                    System.out.print("Enter the radius of the circle: ");
                    double radius = scanner.nextDouble();
                    Circle circle = new Circle(radius);
                    area = circle.getArea();
                    perimeter = circle.getPerimeter();
                    break;
                case 2:
                    System.out.print("Enter the major axis of the ellipse: ");
                    double majorAxis = scanner.nextDouble();
                    System.out.print("Enter the minor axis of the ellipse: ");
                    double minorAxis = scanner.nextDouble();
                    Ellipse ellipse = new Ellipse(majorAxis, minorAxis);
                    area = ellipse.getArea();
                    perimeter = ellipse.getPerimeter();
                    break;
                case 3:
                    System.out.print("Enter the length of side 1 of the triangle: ");
                    double side1 = scanner.nextDouble();
                    System.out.print("Enter the length of side 2 of the triangle: ");
                    double side2 = scanner.nextDouble();
                    System.out.print("Enter the length of side 3 of the triangle: ");
                    double side3 = scanner.nextDouble();
                    Triangle triangle = new Triangle(side1, side2, side3);
                    area = triangle.getArea();
                    perimeter = triangle.getPerimeter();
                    break;
                case 4:
                    System.out.print("Enter the length of the rectangle: ");
                    double length = scanner.nextDouble();
                    System.out.print("Enter the width of the rectangle: ");
                    double width = scanner.nextDouble();
                    Rectangle rectangle = new Rectangle(length, width);
                    area = rectangle.getArea();
                    perimeter = rectangle.getPerimeter();
                    break;
                case 5:
                    System.out.print("Enter the side length of the square: ");
                    double side = scanner.nextDouble();
                    Square square = new Square(side);
                    area = square.getArea();
                    perimeter = square.getPerimeter();
                    break;
                case 6:
                    System.out.println("Exiting program.");
                    return;
                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 6.");
                    continue;
            }

            System.out.println("Area: " + area);
            System.out.println("Perimeter: " + perimeter);
        }
    }
}