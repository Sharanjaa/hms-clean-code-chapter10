package com.company.account;

import com.company.encapsulation.Transaction;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.regex.Pattern;

/**
account class
*/
public class Account {

    public String accountId;
    public List<Transaction> transactions;
    public AccountType accountType;

    public Account(String accountId, AccountType accountType) {
        validateAccountId(accountType, accountId);
        this.accountId = accountId;
        this.accountType = accountType;
        this.transactions = new ArrayList<>();
    }

    public String getAccountId() {
        return accountId;
    }

    private void validateAccountId(AccountType type, String accountId) {
        if (type == AccountType.RETAIL) {
            if(!(accountId != null && Pattern.matches("/^[a-zA-Z]{12}$/", accountId))) {
                throw new RuntimeException("Retial Account Id is null or in wrong format");
            }
        } else if(type == AccountType.CORPORATE) {
            if(!(accountId != null && Pattern.matches("/^[a-zA-Z]{10}$/", accountId))) {
                throw new RuntimeException("Corperate Account Id is null or in wrong format");
            }
        }
    }



}
