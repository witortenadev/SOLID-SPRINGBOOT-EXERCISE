package com.witortena.solid.order;

import com.witortena.solid.domain.Product;

import java.util.List;

public class OrderCreator {
    public Order create(String orderId, List<Product> products) {
        Order order = new Order(orderId);
        products.forEach(order::addItem);
        return order;
    }
}
