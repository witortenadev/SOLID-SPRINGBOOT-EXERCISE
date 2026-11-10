package com.witortena.solid.domain;

import java.math.BigDecimal;

public class Hamburguer extends Product {
    public Hamburguer(String name, BigDecimal price) {
        super(name, price);
    }

    @Override
    public String getType() {
        return "Hamburguer";
    }

    @Override
    public String getDescription() {
        return "Hamburguer " + getName() + " por R$ " + getPrice();
    }
}
