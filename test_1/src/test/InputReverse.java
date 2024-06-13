//does the same thing than the String Reverse, but it takes user input instead of having to modify the code 

package test;
import java.util.Scanner;

public class InputReverse {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String frase = scanner.nextLine();
        
        String reversedString = new StringBuilder(frase).reverse().toString();
        System.out.println("Reversed string: " + reversedString);
        // Do not forget to close your "scanner"
        scanner.close();
    }
}
