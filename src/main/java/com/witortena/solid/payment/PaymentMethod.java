package com.witortena.solid.payment;

import java.math.BigDecimal;

public interface PaymentMethod {
    String getName();

    BigDecimal calculateFinalAmount(BigDecimal totalAmount);
}
