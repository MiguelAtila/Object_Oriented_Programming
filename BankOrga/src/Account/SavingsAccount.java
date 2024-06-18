package Account;

import Transaction.Transaction;
import Transaction.TransactionEnum;

public class SavingsAccount extends AbstractAccount {
    private int withdrawalCount = 0;
    private final double interestRate = 0.15;

    public SavingsAccount() {
        super();
        setOpenFee(0.0); // Llamar al método de AbstractAccount
        setMaintenanceFee(0.0); // Llamar al método de AbstractAccount
    }

    @Override
    public double withdraw(double amount) throws AccountException {
        if (withdrawalCount >= 2 || amount > 500) {
            throw new AccountException("Exceeds withdrawal limit.");
        }
        double newBalance = getBalance() - amount;
        withdrawalCount++;
        Transaction transaction = new Transaction(TransactionEnum.WITHDRAWAL, "Withdrawal", amount);
        movements.put(transaction.getId(), transaction);
        return newBalance;
    }

    @Override
    public double transfer(double amount, String concept) throws AccountException {
        throw new AccountException("Transfers are not allowed in Savings Account.");
    }

    public double estimateInterest(int days) {
        return getBalance() * Math.pow(1 + interestRate / 365, days) - getBalance();
    }

    @Override
    public void setOpenFee(double fee) {
        this.openFee = fee;
    }

    @Override
    public void setMaintenanceFee(double fee) {
        this.maintenanceFee = fee;
    }

    @Override
    public double getOpenFee() {
        return openFee;
    }

    @Override
    public double getMaintenanceFee() {
        return maintenanceFee;
    }

    @Override
    public String toString() {
        return "SavingsAccount{" +
                "accountNumber='" + getAccountNumber() + '\'' +
                ", name='" + getName() + '\'' +
                ", email='" + getEmail() + '\'' +
                ", phoneNumber='" + getPhoneNumber() + '\'' +
                ", balance=" + getBalance() +
                '}';
    }
}
