package com.company;

import com.company.encapsulation.Account;
import com.company.encapsulation.Transaction;
import com.company.v1.util.EmailNotificationService;
import com.company.v1.util.NotificationService;
import com.company.v1.util.SMSNotificationService;

public class Main {

    public static void main(String[] args) {

        NotificationService emailNotificationService = new EmailNotificationService();
        NotificationService smsNotificationService = new SMSNotificationService();

        Account account = new Account("100", "John", smsNotificationService);
        Transaction firstTransaction = new Transaction(1, 50000);
        Transaction secondTransaction = new Transaction(2, 10000);
        Transaction thirdTransaction = new Transaction(3, -2000);
        account.addTransactions(firstTransaction);
        account.addTransactions(secondTransaction);
        account.addTransactions(thirdTransaction);
        System.out.println(account.getCurrentBalance());
    }
}
