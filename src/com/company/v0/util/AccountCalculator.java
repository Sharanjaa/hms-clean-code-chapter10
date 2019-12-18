package com.company.v0.util;

import java.util.List;

public class AccountCalculator {

    public int calculateBalance(List<Integer> transactions) {
        return transactions.stream().mapToInt(Integer::intValue).sum();
    }
}
