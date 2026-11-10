package com.witortena.solid.service;

import com.witortena.solid.interfaces.ReportGenerator;
import com.witortena.solid.order.Order;

import java.math.BigDecimal;
import java.util.List;

public class SalesReportGenerator implements ReportGenerator {
    @Override
    public String generateReport(List<Order> orders) {
        BigDecimal total = orders.stream()
                .map(Order::getTotalAmount)
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        return "Relatório de vendas: " + orders.size() + " pedidos | total: R$ " + total;
    }
}
