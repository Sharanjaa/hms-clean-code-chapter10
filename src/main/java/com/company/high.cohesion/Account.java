package com.company.high.cohesion;

import com.company.account.AccountType;
import com.company.validator.AccountValidator;

import java.util.ArrayList;
import java.util.List;

public class Account {

    private String accountId;
    private AccountType accountType;
    private String customerId;

    public Account(String accountId, String customerId, AccountType accountType, AccountValidator validator) {
        validator.validateAccountId(accountType, accountId);
        this.accountId = accountId;
        this.customerId = customerId;
        this.accountType = accountType;
    }

    public String getAccountId() {
        return accountId;
    }

    public String getCustomerId() {
        return customerId;
    }

}

