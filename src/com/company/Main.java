package com.company;

import com.company.account.Account;
import com.company.util.EmailNotificationService;
import com.company.util.NotificationService;
import com.company.util.SMSNotificationService;

public class Main {

    public static void main(String[] args) {

        NotificationService emailNotificationService = new EmailNotificationService();
        NotificationService smsNotificationService = new SMSNotificationService();

        Account account1 = new Account("100", "John", smsNotificationService);
        account1.addTransactions(50000);
        account1.addTransactions(10000);
        account1.addTransactions(-2000);
        System.out.println(account1.getCurrentBalance());
    }
}
