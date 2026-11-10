package com.witortena.solid.service;

import com.witortena.solid.interfaces.DeliveryManager;

public class DeliveryCoordinator implements DeliveryManager {
    @Override
    public String assignDelivery(String orderId, String courierName) {
        return "Pedido " + orderId + " atribuído ao entregador " + courierName;
    }

    @Override
    public String updateStatus(String orderId, String status) {
        return "Pedido " + orderId + " atualizado para " + status;
    }
}
