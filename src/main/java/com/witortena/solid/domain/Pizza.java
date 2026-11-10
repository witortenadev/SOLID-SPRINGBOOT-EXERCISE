package com.witortena.solid.domain;

import java.math.BigDecimal;

public class Pizza extends Product {
    public Pizza(String name, BigDecimal price) {
        super(name, price);
    }

    @Override
    public String getType() {
        return "Pizza";
    }

    @Override
    public String getDescription() {
        return "Pizza " + getName() + " por R$ " + getPrice();
    }
}
