package com.witortena.solid.order;

public class OrderSaver {
    private final OrderRepository orderRepository;

    public OrderSaver(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public Order save(Order order) {
        orderRepository.save(order);
        return order;
    }
}
