package banking.transactions;

import java.util.Random;

public class Transaction {
    private String id;
    private TransactionEnum transactionType;
    private String concept;
    private double amount;

    public Transaction(TransactionEnum transactionType, String concept, double amount) {
        this.transactionType = transactionType;
        this.concept = concept;
        this.amount = amount;
        this.id = generateTransactionId();
    }

    private String generateTransactionId() {
        StringBuilder idBuilder = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < 4; i++) {
            idBuilder.append(random.nextInt(10));
        }
        for (int i = 0; i < 3; i++) {
            idBuilder.append("-");
            for (int j = 0; j < 4; j++) {
                idBuilder.append(random.nextInt(10));
            }
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