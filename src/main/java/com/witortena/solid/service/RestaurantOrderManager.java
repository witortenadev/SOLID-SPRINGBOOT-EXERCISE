package com.witortena.solid.service;

import com.witortena.solid.domain.Product;
import com.witortena.solid.interfaces.OrderManager;
import com.witortena.solid.order.InMemoryOrderRepository;
import com.witortena.solid.order.Order;
import com.witortena.solid.order.OrderCreator;
import com.witortena.solid.order.OrderDisplay;
import com.witortena.solid.order.OrderRepository;
import com.witortena.solid.order.OrderSaver;

import java.util.List;

public class RestaurantOrderManager implements OrderManager {
    private final OrderCreator orderCreator = new OrderCreator();
    private final OrderSaver orderSaver;
    private final OrderDisplay orderDisplay = new OrderDisplay();

    public RestaurantOrderManager() {
        this(new InMemoryOrderRepository());
    }

    public RestaurantOrderManager(OrderRepository orderRepository) {
        this.orderSaver = new OrderSaver(orderRepository);
    }

    @Override
    public Order createOrder(String id, List<Product> products) {
        Order order = orderCreator.create(id, products);
        return saveOrder(order);
    }

    @Override
    public Order saveOrder(Order order) {
        return orderSaver.save(order);
    }

    @Override
    public String displayOrder(Order order) {
        return orderDisplay.show(order);
    }
}
