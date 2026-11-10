package com.witortena.solid.notification;

import com.witortena.solid.interfaces.NotificationChannel;

public class EmailNotificationChannel implements NotificationChannel {
    @Override
    public void send(String recipient, String message) {
        System.out.println("[Email] Para " + recipient + ": " + message);
    }
}
