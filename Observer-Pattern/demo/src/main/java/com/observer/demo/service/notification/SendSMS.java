package com.observer.demo.service.notification;

public class SendSMS implements NotificationService {
    @Override
    public void sendNotification() {
        System.out.println("Welcome SMS sent");
    }
}