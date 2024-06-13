package banking.accounts.exceptions;

//use "extends" for inheritance 
public class AccountException extends Exception {
public AccountException(String message) {
   super(message);
}
}