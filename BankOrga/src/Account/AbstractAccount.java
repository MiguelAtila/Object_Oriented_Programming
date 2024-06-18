package Account;

import Transaction.Transaction;
import Transaction.TransactionEnum;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public abstract class AbstractAccount implements AccountInterface {
    private String accountNumber;
    private String name;
    private String email;
    private String phoneNumber;
    private double balance;
    protected double openFee;
    protected double maintenanceFee;
    protected HashMap<String, Transaction> movements = new HashMap<>();

    @Override
    public void createAccount(String name, String email, String phoneNumber, double initialBalance) throws AccountException {
        if (initialBalance < 0) {
            throw new AccountCreationException("Initial balance cannot be negative.");
        }
        setName(name);
        setEmail(email);
        setPhoneNumber(phoneNumber);
        this.balance = initialBalance - getOpenFee() - getMaintenanceFee();
        if (this.balance < 0) {
            throw new AccountCreationException("Initial balance is insufficient to cover fees.");
        }
        this.accountNumber = generateAccountNumber();
    }

    private String generateAccountNumber() {
        return String.valueOf((long) (Math.random() * 1_000_000_000_000_000_000L));
    }

    @Override
    public String getAccountNumber() {
        return accountNumber;
    }

    @Override
    public boolean setEmail(String email) throws AccountException {
        if (!isValidEmail(email)) {
            throw new AccountException("Invalid email format.");
        }
        this.email = email;
        return true;
    }

    @Override
    public String getEmail() {
        return email;
    }

    @Override
    public boolean setPhoneNumber(String phoneNumber) throws AccountException {
        if (!isValidPhoneNumber(phoneNumber)) {
            throw new AccountException("Invalid phone number format.");
        }
        this.phoneNumber = phoneNumber;
        return true;
    }

    @Override
    public String getPhoneNumber() {
        return phoneNumber;
    }

    @Override
    public boolean setName(String name) throws AccountException {
        if (name == null || name.isEmpty()) {
            throw new AccountException("Name cannot be empty.");
        }
        this.name = name;
        return true;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public double getBalance() {
        return balance;
    }

    @Override
    public double consultTransaction(String id) throws AccountException {
        if (!movements.containsKey(id)) {
            throw new AccountException("Transaction ID not found.");
        }
        return movements.get(id).getAmount();
    }

    private boolean isValidEmail(String email) {
        String emailRegex = "^[A-Za-z0-9+_.-]+@(.+)$";
        Pattern pattern = Pattern.compile(emailRegex);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    private boolean isValidPhoneNumber(String phoneNumber) {
        String phoneRegex = "\\d{10}";
        Pattern pattern = Pattern.compile(phoneRegex);
        Matcher matcher = pattern.matcher(phoneNumber);
        return matcher.matches();
    }

    // Abstract methods to be implemented by subclasses
    public abstract double withdraw(double amount) throws AccountException;
    public abstract double transfer(double amount, String concept) throws AccountException;

    // Abstract methods for fee configuration
    public abstract void setOpenFee(double fee);
    public abstract void setMaintenanceFee(double fee);
    
    // Abstract methods for retrieving fees
    public abstract double getOpenFee();
    public abstract double getMaintenanceFee();
}
