package com.witortena.solid.notification;

import com.witortena.solid.interfaces.NotificationChannel;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class NotificationService {
    private final NotificationChannel channel;

    public void send(String recipient, String message) {
        channel.send(recipient, message);
    }
}
