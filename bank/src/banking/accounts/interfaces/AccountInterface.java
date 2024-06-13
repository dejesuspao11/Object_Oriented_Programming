package banking.accounts.interfaces;

import banking.accounts.exceptions.AccountException;

public interface AccountInterface {
    void createAccount(String name, String email, String phoneNumber, double initialBalance) throws AccountException;
    String getAccountNumber();
    boolean setEmail(String email) throws AccountException;
    String getEmail() throws AccountException;
    boolean setPhoneNumber(String phoneNumber) throws AccountException;
    String getPhoneNumber() throws AccountException;
    boolean setName(String name) throws AccountException;
    String getName() throws AccountException;
    double getBalance();
    void withdraw(double amount, String concept) throws AccountException;
    double transfer(double amount, String concept) throws AccountException;
    String consultTransaction(String Id) throws AccountException;
}