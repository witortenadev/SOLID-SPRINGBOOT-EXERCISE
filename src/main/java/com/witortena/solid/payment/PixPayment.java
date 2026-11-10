package com.witortena.solid.payment;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class PixPayment implements PaymentMethod {
    private static final BigDecimal DISCOUNT = new BigDecimal("0.97");

    @Override
    public String getName() {
        return "PIX";
    }

    @Override
    public BigDecimal calculateFinalAmount(BigDecimal totalAmount) {
        return totalAmount.multiply(DISCOUNT).setScale(2, RoundingMode.HALF_UP);
    }
}
