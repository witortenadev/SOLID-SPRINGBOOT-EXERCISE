package com.witortena.solid.order;

import com.witortena.solid.domain.Product;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class Order {
    private final String id;
    private final List<Product> items = new ArrayList<>();
    private String status;

    public Order(String id) {
        this.id = id;
        this.status = "CREATED";
    }

    public void addItem(Product product) {
        items.add(product);
    }

    public BigDecimal getTotalAmount() {
        return items.stream()
                .map(Product::getPrice)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }
}
