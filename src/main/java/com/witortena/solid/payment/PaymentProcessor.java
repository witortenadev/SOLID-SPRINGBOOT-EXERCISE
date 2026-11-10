package com.witortena.solid.payment;

import com.witortena.solid.order.Order;

import java.math.BigDecimal;

public class PaymentProcessor {
    public BigDecimal process(Order order, PaymentMethod paymentMethod) {
        BigDecimal total = order.getTotalAmount();
        BigDecimal finalAmount = paymentMethod.calculateFinalAmount(total);
        order.setStatus("PAID");
        return finalAmount;
    }
}
