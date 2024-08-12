package com.companyname.school.files;

import java.util.Scanner;

public class MainMenu {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ReadTable readTable = new ReadTable();
        UpdateTable updateTable = new UpdateTable();
        DeleteTable deleteTable = new DeleteTable();
        CreateTable createTable = new CreateTable(); // Needed for addStudent method

        while (true) {
            System.out.println("Choose an operation:");
            System.out.println("1. Read Students");
            System.out.println("2. Update Student Major");
            System.out.println("3. Delete Student");
            System.out.println("4. Add Student");
            System.out.println("5. Exit");

            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                    readTable.readStudents();
                    break;
                case 2:
                    System.out.print("Enter Student ID to update: ");
                    int studentId = scanner.nextInt();
                    scanner.nextLine();  // Consume newline
                    System.out.print("Enter new major: ");
                    String newMajor = scanner.nextLine();
                    updateTable.updateStudentMajor(studentId, newMajor);
                    break;
                case 3:
                    System.out.print("Enter Student ID to delete: ");
                    int deleteId = scanner.nextInt();
                    deleteTable.deleteStudent(deleteId);
                    break;
                case 4:
                    createTable.addStudent();
                    break;
                case 5:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
