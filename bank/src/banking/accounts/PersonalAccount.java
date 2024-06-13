package banking.accounts;

import banking.accounts.exceptions.AccountException;

public class PersonalAccount extends AbstractAccount {
    private static final double MAX_WITHDRAWAL_LIMIT = 500.0;
    private static final double MINIMUM_BALANCE = 1000.0;
    private static final double OPEN_FEE = 2.0;
    private static final double MAINTENANCE_FEE = 10.0;

    public PersonalAccount(double initialBalance) throws AccountException {
        if (initialBalance < 0) {
            throw new AccountException("Initial balance must be non-negative");
        }
        balance = initialBalance - OPEN_FEE;
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
        balance += initialBalance;
    }

    @Override
    public void withdraw(double amount, String concept) throws AccountException {
        if (balance - amount < MINIMUM_BALANCE) {
            throw new AccountException("Withdrawal amount exceeds minimum balance");
        }
        if (amount > MAX_WITHDRAWAL_LIMIT) {
            throw new AccountException("Withdrawal amount exceeds maximum withdrawal limit");
        }
        balance -= amount;
    }

    @Override
    public double transfer(double amount, String concept) throws AccountException {
        if (balance - amount < MINIMUM_BALANCE) {
            throw new AccountException("Transfer amount exceeds minimum balance");
        }
        if (amount > MAX_WITHDRAWAL_LIMIT) {
            throw new AccountException("Transfer amount exceeds maximum withdrawal limit");
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
        return generateAccountNumber();
    }

    @Override
    public String toString() {
        return "Personal Account Details:\n" +
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