package com.witortena.solid.interfaces;

import com.witortena.solid.domain.Product;
import com.witortena.solid.order.Order;

import java.util.List;

public interface OrderManager {
    Order createOrder(String id, List<Product> products);

    Order saveOrder(Order order);

    String displayOrder(Order order);
}
