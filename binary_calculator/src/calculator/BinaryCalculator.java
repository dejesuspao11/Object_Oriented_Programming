package calculator;

	import java.util.Scanner;

public class BinaryCalculator {
    // addition method
    public static String addBinary(String binary1, String binary2) {
        // converts binary to decimal to do the addition 
    	// the number 2 specifies the string is a binary number
        int num1 = Integer.parseInt(binary1, 2);
        int num2 = Integer.parseInt(binary2, 2);
        // adds the decimal numbers
        int sum = num1 + num2;
        // converts the result sum back to binary
        return Integer.toBinaryString(sum);
    }

    // subtraction method
    public static String subtractBinary(String binary1, String binary2) {
        // converts binary to decimal
        int num1 = Integer.parseInt(binary1, 2);
        int num2 = Integer.parseInt(binary2, 2);
        // subtraction 
        int diff = num1 - num2;
        // converts back to binary
        return Integer.toBinaryString(diff);
    }

    // convert number to binary
    // defines a method named "toBinary", this method will take a single argument
    // the argument is called "number" and is a float type
    //the method is expected to return a String type of value, so...
	//the method will take the given float number, convert into a binary and return it as a string.
    public static String toBinary(float number) {
    	//Float.floatToIntBits(number) -> takes the bits that represent the float number and converts 
    	//them to an integer without changing the actual value.
    	//Interger.toBinary is a method that takes an integer as the argument and returns the binary 
    	//representation of that integer as a string type.
        return Integer.toBinaryString(Float.floatToIntBits(number));
    }

 // get the hexadecimal representation of a number
    public static String toHex(float number) {
        //intNumber is a variable of type integer
    	//(int) is a cast operator that converts the given value to the specified type
    	// it truncates the decimal part of the float number, keeping only the integer part (5.7 = 5)
        int intNumber = (int) number;
        //this part takes an integer as input and converts it to a hexadecimal representation as a String type
        return Integer.toHexString(intNumber);
    }

    //get the octal representation of a number
    public static String toOctal(float number) {
        //same process as Hex 
    	int intNumber = (int) number;
        return Integer.toOctalString(intNumber);
    }
    	
    //the main method is the entry point for any Java program
    //"public" keyword means that this method can be accessed from outside the class
    
    //"void" means that the method does not return any value
    //(String[] args) is the parameter list, args is an array of strings
      //Parameter lists are another way of defining terms in a list form
      //The parameter list of a function describes the number and types of the arguments that the function accepts, 
    	//and the number and types of the values it returns.
    public static void main(String[] args) {
    	//creates a new Scanner object named "scanner" that reads input from the keyboard
        Scanner scanner = new Scanner(System.in);

        // menu
        // System.out.println is the way to print in Java
        System.out.println("1. Add Binary Numbers");
        System.out.println("2. Subtract Binary Numbers");
        System.out.println("3. Convert Number to Binary");
        System.out.println("4. Get Hexadecimal Representation");
        System.out.println("5. Get Octal Representation");
        System.out.print("Choose an option: ");

        //this line reads an integer input from the user using the Scanner object named "scanner"
        //nextInt() is a method of the Scanner class that reads the next token of input as an integer type
        //input is coming from the keyboard (System.in) as we specified on "Scanner scanner = new Scanner(System.in);"
        int choice = scanner.nextInt();
        //nextInt() reads the integer input, but it does NOT consume the newline character (Enter key) from the input stream
        //scanner.nextLine() consumes the leftover newline character after nextInt().
        scanner.nextLine();

        switch (choice) {
            case 1:
                System.out.print("Enter first binary number: ");
                String binary1 = scanner.nextLine();
                System.out.print("Enter second binary number: ");
                String binary2 = scanner.nextLine();
                System.out.println("Result: " + addBinary(binary1, binary2));
                break;
            case 2:
                System.out.print("Enter first binary number: ");
                String binary3 = scanner.nextLine();
                System.out.print("Enter second binary number: ");
                String binary4 = scanner.nextLine();
                System.out.println("Result: " + subtractBinary(binary3, binary4));
                break;
            case 3:
                System.out.print("Enter a number: ");
                float number = scanner.nextFloat();
                System.out.println("Binary representation: " + toBinary(number));
                break;
            case 4:
                System.out.print("Enter a number: ");
                float number2 = scanner.nextFloat();
                System.out.println("Hexadecimal representation: " + toHex(number2));
                break;
            case 5:
                System.out.print("Enter a number: ");
                float number3 = scanner.nextFloat();
                System.out.println("Octal representation: " + toOctal(number3));
                break;
            default:
                System.out.println("option not found, try again!");
        }
        //it's good practice to close the Scanner object when you're done using it
        //closing it releases any system resources associated with it
        scanner.close();
    }
}