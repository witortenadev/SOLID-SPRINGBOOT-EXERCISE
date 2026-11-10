package com.witortena.solid.interfaces;

import com.witortena.solid.order.Order;

import java.util.List;

public interface ReportGenerator {
    String generateReport(List<Order> orders);
}
