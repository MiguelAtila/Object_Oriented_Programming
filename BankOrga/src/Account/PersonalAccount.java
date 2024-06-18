package Account;

import Transaction.Transaction;
import Transaction.TransactionEnum;

public class PersonalAccount extends AbstractAccount {

    public PersonalAccount() {
        super();
        setOpenFee(2.0); // Llama al método de AbstractAccount
        setMaintenanceFee(10.0); // Llama al método de AbstractAccount
    }

    @Override
    public double withdraw(double amount) throws AccountException {
        if (amount > 500 || getBalance() - amount < 1000) {
            throw new AccountException("Exceeds withdrawal limit or insufficient funds for minimum balance.");
        }
        double newBalance = getBalance() - amount;
        Transaction transaction = new Transaction(TransactionEnum.WITHDRAWAL, "Withdrawal", amount);
        movements.put(transaction.getId(), transaction);
        return newBalance;
    }

    @Override
    public double transfer(double amount, String concept) throws AccountException {
        if (amount > 500 || getBalance() - amount < 1000) {
            throw new AccountException("Exceeds transfer limit or insufficient funds for minimum balance.");
        }
        double newBalance = getBalance() - amount;
        Transaction transaction = new Transaction(TransactionEnum.CHARGES, concept, amount);
        movements.put(transaction.getId(), transaction);
        return newBalance;
    }

    @Override
    public void setOpenFee(double fee) { // Cambiado a public
        this.openFee = fee;
    }

    @Override
    public void setMaintenanceFee(double fee) { // Cambiado a public
        this.maintenanceFee = fee;
    }

    @Override
    public double getOpenFee() {
        return this.openFee;
    }

    @Override
    public double getMaintenanceFee() {
        return this.maintenanceFee;
    }

    @Override
    public String toString() {
        return "PersonalAccount{" +
                "accountNumber='" + getAccountNumber() + '\'' +
                ", name='" + getName() + '\'' +
                ", email='" + getEmail() + '\'' +
                ", phoneNumber='" + getPhoneNumber() + '\'' +
                ", balance=" + getBalance() +
                '}';
    }
}
