package com.company.v1.account;

import com.company.v1.util.EmailNotificationService;
import com.company.v1.util.NotificationService;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Account {

    private String accountId;
    private String customerId;
    private List<Transaction> transactions;
    private NotificationService notificationService;

    public Account(String accountId, String customerId, NotificationService notificationService) {
        this.accountId = accountId;
        this.customerId = customerId;
        this.notificationService = notificationService;
        this.transactions = new ArrayList<>();
        validateAccountId(accountId);
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public List<Transaction> getTransactions() {
        return  Collections.unmodifiableList(this.transactions);
    }

    private void validateAccountId(String accountId) {
        if (!(accountId != null && accountId.length() == 13)) {
            throw new RuntimeException("Account Id is null or in wrong format");
        }
    }

    public void addTransactions(Transaction transaction) {
        this.transactions.add(transaction);
        this.notifyTransaction(transaction);
    }

    public int getCurrentBalance() {
        return transactions.stream().mapToInt(Transaction::getTransactionAmount).sum();
    }

    public void notifyTrasactionViaEmail(int transaction) {
        EmailNotificationService emailService = new EmailNotificationService();
        emailService.notify(this.customerId, "You have a transaction of: " + transaction);
    }

    public void notifyTransaction(Transaction transaction) {
        notificationService.notify(this.customerId, "You have a transaction of: " + transaction);
    }

}
