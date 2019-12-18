package com.company.v1.util;

public class SMSNotificationService implements NotificationService {

    @Override
    public void notify(String customnerId, String message) {
        System.out.println("Sending SMS to: " + customnerId + ". Message: " + message);
    }
}
