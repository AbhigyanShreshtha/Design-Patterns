package com.observer.demo.service.notification;

public class NotificationFactory {
    public static NotificationService getNotificationService(String type) {
        if (type.equalsIgnoreCase("email")) {
            return new SendEmail();
        } else if (type.equalsIgnoreCase("sms")) {
            return new SendSMS();
        }
        throw new IllegalArgumentException("Unknown notification type");
    }
}