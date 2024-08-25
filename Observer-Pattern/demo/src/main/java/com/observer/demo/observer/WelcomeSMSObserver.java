package com.observer.demo.observer;

import com.observer.demo.service.notification.NotificationFactory;
import com.observer.demo.service.notification.NotificationService;
import org.springframework.stereotype.Component;

@Component
public class WelcomeSMSObserver implements Observer {

    @Override
    public void update(String userId) {
        NotificationService smsService = NotificationFactory.getNotificationService("sms");
        smsService.sendNotification();
    }
}