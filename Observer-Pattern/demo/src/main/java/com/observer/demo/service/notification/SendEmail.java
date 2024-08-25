package com.observer.demo.service.notification;

public class SendEmail implements NotificationService {
    @Override
    public void sendNotification() {
        System.out.println("Welcome email sent");
    }
}