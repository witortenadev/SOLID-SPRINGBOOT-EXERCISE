package com.witortena.solid.interfaces;

public interface DeliveryManager {
    String assignDelivery(String orderId, String courierName);

    String updateStatus(String orderId, String status);
}
