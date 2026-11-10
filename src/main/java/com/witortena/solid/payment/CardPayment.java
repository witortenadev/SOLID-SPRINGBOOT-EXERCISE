package com.witortena.solid.payment;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class CardPayment implements PaymentMethod {
    private static final BigDecimal FEE = new BigDecimal("0.04");

    @Override
    public String getName() {
        return "Cartão";
    }

    @Override
    public BigDecimal calculateFinalAmount(BigDecimal totalAmount) {
        return totalAmount.add(totalAmount.multiply(FEE)).setScale(2, RoundingMode.HALF_UP);
    }
}
