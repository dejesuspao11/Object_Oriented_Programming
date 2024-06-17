package app;

import shipping.items.Letter;
import shipping.items.MailItem;
import senders.recipients.User;
import enums.DistributionPoints;

import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class MailTerminalApp {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Collect sender's information
        System.out.println("Sender's Information:");
        User sender = getUserDetails(scanner);

        // Collect recipient's information
        System.out.println("\nRecipient's Information:");
        User recipient = getUserDetails(scanner);

        // Select type of package
        System.out.println("\nSelect Package Type:");
        System.out.println("1. Letter");
        System.out.println("2. Mail Item");

        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume newline character

        if (choice == 1) {
            // Send a letter
            Letter letter = new Letter(sender, recipient);
            System.out.println("\nEstimated Arrival: " + letter.getEstimateArrival().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")));
            System.out.println("Estimated Price: $" + letter.estimatePrice());
        } else if (choice == 2) {
            // Send a mail item
            System.out.print("Enter weight (in kg): ");
            double weight = scanner.nextDouble();
            scanner.nextLine(); // Consume newline character

            System.out.print("Enter content description: ");
            String contentDescription = scanner.nextLine();

            MailItem mailItem = new MailItem(sender, recipient, weight, contentDescription);
            System.out.println("\nEstimated Arrival: " + mailItem.getEstimateArrival().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")));
            System.out.println("Estimated Price: $" + mailItem.estimatePrice());
        } else {
            System.out.println("Invalid choice. Please select 1 or 2.");
        }
    }

    private static User getUserDetails(Scanner scanner) {
        User user = null;
        try {
            System.out.print("Full Name: ");
            String fullName = scanner.nextLine();

            System.out.print("Address (postal code): ");
            String address = scanner.nextLine();

            System.out.print("Phone Number (+52XXXXXXXXXX): ");
            String phoneNumber = scanner.nextLine();

            System.out.print("Email (must be @gmail.com): ");
            String email = scanner.nextLine();

            user = new User(fullName, address, phoneNumber, email);
        } catch (User.UserException e) {
            System.out.println("Error: " + e.getMessage());
            System.exit(1); // Exit if user details are not valid
        }
        return user;
    }
}
