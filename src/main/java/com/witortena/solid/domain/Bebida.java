package com.witortena.solid.domain;

import java.math.BigDecimal;

public class Bebida extends Product {
    public Bebida(String name, BigDecimal price) {
        super(name, price);
    }

    @Override
    public String getType() {
        return "Bebida";
    }

    @Override
    public String getDescription() {
        return "Bebida " + getName() + " por R$ " + getPrice();
    }
}
