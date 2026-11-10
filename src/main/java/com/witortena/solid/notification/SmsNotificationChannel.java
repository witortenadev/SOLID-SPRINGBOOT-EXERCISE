package com.witortena.solid.notification;

import com.witortena.solid.interfaces.NotificationChannel;

public class SmsNotificationChannel implements NotificationChannel {
    @Override
    public void send(String recipient, String message) {
        System.out.println("[SMS] Para " + recipient + ": " + message);
    }
}
