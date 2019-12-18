package com.company.util;

import java.util.List;

public class AccountCalculator {

    public int calculateBalance(List<Integer> transactions) {
        return transactions.stream().mapToInt(Integer::intValue).sum();
    }
}
