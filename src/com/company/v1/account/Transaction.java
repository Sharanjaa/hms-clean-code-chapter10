package com.company.v1.account;

public class Transaction {

    private int transactionId;
    private int transactionAmount;

    public Transaction(int transactionId, int transactionAmount) {
        this.transactionId = transactionId;
        this.transactionAmount = transactionAmount;
    }

    public int getTransactionId() {
        return transactionId;
    }

    public int getTransactionAmount() {
        return transactionAmount;
    }
}
