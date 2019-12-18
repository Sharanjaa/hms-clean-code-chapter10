package com.company.v0.encapsulation;

import com.company.v0.account.Transaction;

import java.util.List;


public class Account {

    private String accountId;
    private String accountHolderName;
    private String customerId;
    private List<Transaction> transactions;

    public Account(String accountId, String accountHolderName, String customerId, List<Transaction> transactions) {
        this.accountId = accountId;
        this.accountHolderName = accountHolderName;
        this.customerId = customerId;
        this.transactions = transactions;
    }

    public String getAccountId() {
        return accountId;
    }

    public String getAccountHolderName() {
        return accountHolderName;
    }

    public void setAccountHolderName(String accountHolderName) {
        this.accountHolderName = accountHolderName;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public void addTransaction(Transaction transaction) {
        transactions.add(transaction);
    }
}
