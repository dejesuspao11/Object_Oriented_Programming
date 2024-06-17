package senders.recipients;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class User {
    private String fullName;
    private String address;
    private String phoneNumber;
    private String email;

    public User(String fullName, String address, String phoneNumber, String email) throws UserException {
        setFullName(fullName);
        setAddress(address);
        setPhoneNumber(phoneNumber);
        setEmail(email);
    }

    // Getters
    public String getFullName() {
        return fullName;
    }

    public String getAddress() {
        return address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    // Setters with validation
    public void setFullName(String fullName) throws UserException {
        if (!fullName.matches("[a-zA-Z ]+")) {
            throw new UserException("Invalid full name format: should only contain letters and spaces");
        }
        this.fullName = fullName;
    }

    public void setAddress(String address) throws UserException {
        // Assuming address validation needs more complex logic, including state verification
        // Here, we are just checking basic format for demonstration
        if (!address.matches("^\\d{5}$")) {
            throw new UserException("Invalid address format: Postal code should be a 5 digit number");
        }
        this.address = address;
    }

    public void setPhoneNumber(String phoneNumber) throws UserException {
        phoneNumber = phoneNumber.trim(); // Remove any leading or trailing whitespace

        if (!phoneNumber.matches("^\\+52\\d{10}$")) {
            throw new UserException("Invalid phone number format: Must be +52 followed by 10 digits");
        }
        this.phoneNumber = phoneNumber;
    }

    public void setEmail(String email) throws UserException {
        if (!email.matches(".+@gmail\\.com")) {
            throw new UserException("Invalid email format: Must be a @gmail.com account");
        }
        this.email = email;
    }

    // Exception class for user-defined exceptions
    public static class UserException extends Exception {
        public UserException(String message) {
            super(message);
        }
    }
}