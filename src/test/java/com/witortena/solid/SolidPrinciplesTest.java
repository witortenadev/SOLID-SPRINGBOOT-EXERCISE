package com.witortena.solid;

import com.witortena.solid.domain.Bebida;
import com.witortena.solid.domain.Hamburguer;
import com.witortena.solid.domain.Pizza;
import com.witortena.solid.domain.Product;
import com.witortena.solid.notification.EmailNotificationChannel;
import com.witortena.solid.notification.NotificationService;
import com.witortena.solid.order.Order;
import com.witortena.solid.order.OrderDisplay;
import com.witortena.solid.payment.CardPayment;
import com.witortena.solid.payment.CashPayment;
import com.witortena.solid.payment.PaymentProcessor;
import com.witortena.solid.payment.PixPayment;
import com.witortena.solid.service.RestaurantOrderManager;
import com.witortena.solid.service.SalesReportGenerator;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class SolidPrinciplesTest {

    @Test
    void shouldCreateSaveAndDisplayOrder() {
        RestaurantOrderManager orderManager = new RestaurantOrderManager();
        List<Product> items = List.of(
                new Pizza("Calabresa", new BigDecimal("45.00")),
                new Hamburguer("X-Bacon", new BigDecimal("30.00")),
                new Bebida("Coca-Cola", new BigDecimal("8.50"))
        );

        Order order = orderManager.createOrder("PED-100", items);

        assertEquals("PED-100", order.getId());
        assertEquals(new BigDecimal("83.50"), order.getTotalAmount());
        assertTrue(orderManager.displayOrder(order).contains("PED-100"));
        assertEquals("CREATED", order.getStatus());
    }

    @Test
    void shouldSupportDifferentPaymentMethods() {
        PaymentProcessor paymentProcessor = new PaymentProcessor();

        Order cardOrder = new Order("PED-101");
        cardOrder.addItem(new Pizza("Muzzarella", new BigDecimal("50.00")));
        BigDecimal cardTotal = paymentProcessor.process(cardOrder, new CardPayment());
        assertEquals(new BigDecimal("52.00"), cardTotal);

        Order pixOrder = new Order("PED-102");
        pixOrder.addItem(new Bebida("Água", new BigDecimal("10.00")));
        BigDecimal pixTotal = paymentProcessor.process(pixOrder, new PixPayment());
        assertEquals(new BigDecimal("9.70"), pixTotal);

        Order cashOrder = new Order("PED-103");
        cashOrder.addItem(new Hamburguer("Veggie", new BigDecimal("35.00")));
        BigDecimal cashTotal = paymentProcessor.process(cashOrder, new CashPayment());
        assertEquals(new BigDecimal("35.00"), cashTotal);
    }

    @Test
    void shouldRespectLiskovAndDependencyInversion() {
        Product pizza = new Pizza("Pepperoni", new BigDecimal("60.00"));
        Product burger = new Hamburguer("Classic", new BigDecimal("35.00"));
        Product drink = new Bebida("Guaraná", new BigDecimal("7.00"));

        assertEquals("Pizza", pizza.getType());
        assertEquals("Hamburguer", burger.getType());
        assertEquals("Bebida", drink.getType());

        NotificationService notificationService = new NotificationService(new EmailNotificationChannel());
        assertDoesNotThrow(() -> notificationService.send("cliente@email.com", "Pedido confirmado!"));

        Order order = new Order("PED-104");
        order.addItem(pizza);
        order.addItem(burger);
        order.addItem(drink);
        assertEquals(new BigDecimal("102.00"), order.getTotalAmount());
    }

    @Test
    void shouldGenerateSalesReportAndDisplayOrderInfo() {
        Order order = new Order("PED-105");
        order.addItem(new Pizza("4 Queijos", new BigDecimal("55.00")));

        String report = new SalesReportGenerator().generateReport(List.of(order));
        assertTrue(report.contains("Relatório de vendas"));

        assertTrue(new OrderDisplay().show(order).contains("PED-105"));
    }
}
