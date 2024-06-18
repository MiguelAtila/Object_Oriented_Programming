package Account;

import Transaction.Transaction;
import Transaction.TransactionEnum;

public class BusinessAccount extends AbstractAccount {

    public BusinessAccount() {
        super();
        this.setOpenFee(100.0);
        this.setMaintenanceFee(50.0);
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
    public double withdraw(double amount) throws AccountException {
        if (getBalance() - amount < 5000) {
            throw new AccountException("Insufficient funds for minimum balance.");
        }
        double newBalance = getBalance() - amount;
        Transaction transaction = new Transaction(TransactionEnum.WITHDRAWAL, "Withdrawal", amount);
        movements.put(transaction.getId(), transaction);
        return newBalance;
    }

    @Override
    public double transfer(double amount, String concept) throws AccountException {
        if (!BusinessConcept.isValidConcept(concept)) {
            throw new AccountException("Invalid transaction concept.");
        }
        double newBalance = getBalance() - amount;
        Transaction transaction = new Transaction(TransactionEnum.CHARGES, concept, amount);
        movements.put(transaction.getId(), transaction);
        return newBalance;
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
        return "BusinessAccount{" +
                "accountNumber='" + getAccountNumber() + '\'' +
                ", name='" + getName() + '\'' +
                ", email='" + getEmail() + '\'' +
                ", phoneNumber='" + getPhoneNumber() + '\'' +
                ", balance=" + getBalance() +
                '}';
    }
}
