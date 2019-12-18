package com.company.account;

import com.company.util.EmailNotificationService;
import com.company.util.NotificationService;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Account {

    private String accountId;
    private String customerId;
    private List<Integer> transactions;
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

    // good encapsulation
    public List<Integer> getTransactions() {
        return  Collections.unmodifiableList(this.transactions);
    }

    // bad encapsulation
    public void setTransactions(List<Integer> transactions) {
        this.transactions = transactions;
    }

    private void validateAccountId(String accountId) {
        if (!(accountId != null && accountId.length() == 13)) {
            throw new RuntimeException("Account Id is null or in wrong format");
        }
    }
    // good encapsulation
    // TODO: 12/18/19 make it as transaction object 
    public void addTransactions(int transaction) {
        this.transactions.add(transaction);
        this.notifyTrasaction(transaction);
    }

    // low cohesion
//    public int getCurrentBalance() {
//        AccountCalculator calculator = new AccountCalculator();
//        return calculator.calculateBalance(this.transactions);
//    }

    // high cohesion
    public int getCurrentBalance() {
        return transactions.stream().mapToInt(Integer::intValue).sum();
    }

    // tighly coupled
    public void notifyTrasactionViaEmail(int transaction) {
        EmailNotificationService emailService = new EmailNotificationService();
        emailService.notify(this.customerId, "You have a transaction of: " + transaction);
    }

    // loosely coupled
    public void notifyTrasaction(int transaction) {
        notificationService.notify(this.customerId, "You have a transaction of: " + transaction);
    }

}
