package test;

public class StringReverse {
	public static void main(String[] args) {
	String frase ="holis";
	String reversedString = new StringBuilder(frase).reverse().toString();
	System.out.println(reversedString);
}
}