package com.company.v1.util;

import com.company.v0.account.Transaction;

import java.util.List;

public class AccountCalculator {

    public int calculateBalance(List<Transaction> transactions) {
        return transactions.stream().mapToInt(Transaction::getTransactionAmount).sum();
    }
}
