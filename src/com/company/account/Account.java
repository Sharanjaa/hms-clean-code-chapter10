package com.company.account;

import com.company.util.EmailNotificationService;
import com.company.util.NotificationService;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.regex.Pattern;

/**
account class
*/
public class Account {

    private String accountId;
    private AccountType type;
    private String customerId;
    private List<Integer> transactions;
    private NotificationService notificationService;

    public Account(String accountId, String customerId, AccountType type) {
        validateAccountId(type, accountId);
        this.accountId = accountId;
        this.customerId = customerId;
        this.type = type;
        this.transactions = new ArrayList<>();
    }

    public String getAccountId() {
        return accountId;
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

    private void validateAccountId(AccountType type, String accountId) {
        if (type == AccountType.Retail) {
            if(!(accountId != null && Pattern.matches("/^[a-zA-Z]{12}$/", accountId))) {
                throw new RuntimeException("Retial Account Id is null or in wrong format");
            }
        } else if(type == AccountType.Corporate) {
            if(!(accountId != null && Pattern.matches("/^[a-zA-Z]{10}$/", accountId))) {
                throw new RuntimeException("Corperate Account Id is null or in wrong format");
            }
        }
    }



}
