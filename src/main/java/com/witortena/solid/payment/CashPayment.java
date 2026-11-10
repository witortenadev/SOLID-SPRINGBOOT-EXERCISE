package com.witortena.solid.payment;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class CashPayment implements PaymentMethod {
    @Override
    public String getName() {
        return "Dinheiro";
    }

    @Override
    public BigDecimal calculateFinalAmount(BigDecimal totalAmount) {
        return totalAmount.setScale(2, RoundingMode.HALF_UP);
    }
}
