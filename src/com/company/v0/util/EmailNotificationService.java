package com.company.v0.util;

public class EmailNotificationService implements NotificationService {

    @Override
    public void notify(String customnerId, String message) {
        System.out.println("Sending Email to: " + customnerId + ". Message: " + message);
    }
}
