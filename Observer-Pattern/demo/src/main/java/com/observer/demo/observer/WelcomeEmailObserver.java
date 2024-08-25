package com.observer.demo.observer;

import com.observer.demo.service.notification.NotificationFactory;
import com.observer.demo.service.notification.NotificationService;
import org.springframework.stereotype.Component;

@Component
public class WelcomeEmailObserver implements Observer {

    @Override
    public void update(String userId) {
        NotificationService emailService = NotificationFactory.getNotificationService("email");
        emailService.sendNotification();
    }
}