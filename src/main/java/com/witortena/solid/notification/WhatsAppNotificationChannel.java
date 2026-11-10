package com.witortena.solid.notification;

import com.witortena.solid.interfaces.NotificationChannel;

public class WhatsAppNotificationChannel implements NotificationChannel {
    @Override
    public void send(String recipient, String message) {
        System.out.println("[WhatsApp] Para " + recipient + ": " + message);
    }
}
