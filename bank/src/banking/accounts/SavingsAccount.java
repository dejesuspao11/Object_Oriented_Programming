package banking.accounts;

import banking.accounts.exceptions.AccountException;

public class SavingsAccount extends AbstractAccount {
    private static final int MAX_WITHDRAWALS = 2;
    private static final double MAX_WITHDRAWAL_AMOUNT = 500.0;
    private static final double INTEREST_RATE = 0.15;

    private int withdrawalCount;

    public SavingsAccount(double initialBalance) throws AccountException {
        if (initialBalance < 0) {
            throw new AccountException("Initial balance must be non-negative");
        }
        balance = initialBalance;
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
        if (withdrawalCount >= MAX_WITHDRAWALS) {
            throw new AccountException("Maximum number of withdrawals reached");
        }
        if (amount > MAX_WITHDRAWAL_AMOUNT) {
            throw new AccountException("Withdrawal amount exceeds maximum withdrawal limit");
        }
        balance -= amount;
        withdrawalCount++;
    }

    @Override
    public double transfer(double amount, String concept) throws AccountException {
        throw new AccountException("Transfers are not allowed for savings accounts");
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
        return "Savings Account Details:\n" +
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