package com.company.account2;

import com.company.account.AccountType;
import com.company.validator.AccountValidator;

import java.util.ArrayList;
import java.util.List;

public class Account {

    private String accountId;
    private AccountType type;
    private String customerId;
    private List<Integer> transactions;

    public Account(String accountId, String customerId, AccountType type) {
        AccountValidator validator = new AccountValidator();
        validator.validateAccountId(type, accountId);
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

}

