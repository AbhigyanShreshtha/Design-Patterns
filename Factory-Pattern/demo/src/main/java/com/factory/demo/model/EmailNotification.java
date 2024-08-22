package com.factory.demo.model;

import org.springframework.stereotype.Component;

@Component
public class EmailNotification implements Notification {
    @Override
    public void sendNotification(String sender, String recipient, String body) {
        System.out.println("Email method invoked");
        System.out.printf("Sending Email from %s to %s with body: %s%n", sender, recipient, body);
    }
}
