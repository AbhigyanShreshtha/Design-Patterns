package com.factory.demo.model;

import org.springframework.stereotype.Component;

@Component
public class SMSNotification implements Notification {
    @Override
    public void sendNotification(String sender, String recipient, String body) {
        System.out.println("SMS method invoked");
        System.out.printf("Sending SMS from %s to %s with body: %s%n", sender, recipient, body);
    }
}