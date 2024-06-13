package banking.accounts;

import banking.accounts.exceptions.AccountException;

//import java.util.HashMap;

public class BusinessAccount extends AbstractAccount {
    private static final double MINIMUM_BALANCE = 5000.0;
    private static final double OPEN_FEE = 100.0;
    private static final double MAINTENANCE_FEE = 50.0;

    private String accountNumber;

    public BusinessAccount(double initialBalance) throws AccountException {
        if (initialBalance < MINIMUM_BALANCE) {
            throw new AccountException("Initial balance must be at least $5000");
        }
        balance = initialBalance - OPEN_FEE;
        accountNumber = generateAccountNumber();
    }

    @Override
    public void createAccount(String name, String email, String phoneNumber, double initialBalance)
            throws AccountException {
        if (!isValidEmail(email)) {
            throw new AccountException("Invalid email format");
        }
        if (!isValidPhoneNumber(phoneNumber)) {
            throw new AccountException("Invalid phone number format");
        }
        if (name.isEmpty()) {
            throw new AccountException("Name cannot be empty");
        }
        //balance += initialBalance;
        balance = initialBalance;
    }

    @Override
    public void withdraw(double amount, String concept) throws AccountException {
        if (amount <= 0) {
            throw new AccountException("Withdrawal amount must be positive");
        }
        balance -= amount;
    }

    @Override
    public double transfer(double amount, String concept) throws AccountException {
        if (amount <= 0) {
            throw new AccountException("Transfer amount must be positive");
        }
        balance -= amount;
        return amount;
    }

    @Override
    public double getBalance() {
        return balance;
    }

    @Override
    public String getAccountNumber() {
        return accountNumber;
    }

    @Override
    public String toString() {
        return "Business Account Details:\n" +
                "Account Number: " + getAccountNumber() + "\n" +
                "Balance: $" + getBalance();
    }

	@Override
	public boolean setEmail(String email) throws AccountException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String getEmail() throws AccountException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean setPhoneNumber(String phoneNumber) throws AccountException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String getPhoneNumber() throws AccountException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean setName(String name) throws AccountException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String getName() throws AccountException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String consultTransaction(String Id) throws AccountException {
		// TODO Auto-generated method stub
		return null;
	}
}