package Transaction;

import java.util.Random;

public class Transaction {
    private String id;
    private TransactionEnum transactionType;
    private String concept;
    private double amount;

    public Transaction(TransactionEnum transactionType, String concept, double amount) {
        this.id = generateTransactionId();
        this.transactionType = transactionType;
        this.concept = concept;
        this.amount = amount;
    }

    private String generateTransactionId() {
        Random random = new Random();
        StringBuilder idBuilder = new StringBuilder();
        for (int i = 0; i < 4; i++) {
            idBuilder.append(String.format("%04d", random.nextInt(10000)));
            if (i < 3) idBuilder.append("-");
        }
        return idBuilder.toString();
    }

    public String getId() {
        return id;
    }

    public TransactionEnum getTransactionType() {
        return transactionType;
    }

    public String getConcept() {
        return concept;
    }

    public double getAmount() {
        return amount;
    }
}
