package banking.accounts;

import java.util.HashMap;
import java.util.regex.Pattern;

import banking.accounts.interfaces.AccountInterface;
import banking.transactions.Transaction;

public abstract class AbstractAccount implements AccountInterface {
    protected double accountLimit;
    protected double openFee;
    protected double maintenanceFee;
    protected double balance;
    protected HashMap<String, Transaction> movements;

    public AbstractAccount() {
        movements = new HashMap<>();
    }

    protected boolean isValidEmail(String email) {
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
        return Pattern.matches(emailRegex, email);
    }

    protected boolean isValidPhoneNumber(String phoneNumber) {
        String phoneRegex = "^\\d{10}$";
        return Pattern.matches(phoneRegex, phoneNumber);
    }

    protected String generateAccountNumber() {
        // Dummy implementation, replace with actual logic to generate account number
        return "123456789012345678";
    }

    protected String generateTransactionId() {
        // Dummy implementation, replace with actual logic to generate transaction ID
        return "txn123456";
    }
}