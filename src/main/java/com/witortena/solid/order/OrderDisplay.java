package com.witortena.solid.order;

public class OrderDisplay {
    public String show(Order order) {
        StringBuilder builder = new StringBuilder();
        builder.append("Pedido: ").append(order.getId()).append(System.lineSeparator());
        builder.append("Status: ").append(order.getStatus()).append(System.lineSeparator());
        builder.append("Itens:").append(System.lineSeparator());

        order.getItems().forEach(item -> builder.append("- ")
                .append(item.getType())
                .append(" ")
                .append(item.getName())
                .append(" - R$ ")
                .append(item.getPrice())
                .append(System.lineSeparator()));

        builder.append("Total: R$ ").append(order.getTotalAmount());
        return builder.toString();
    }
}
