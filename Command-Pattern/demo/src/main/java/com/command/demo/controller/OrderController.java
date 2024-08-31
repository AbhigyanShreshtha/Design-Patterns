package com.command.demo.controller;

import com.command.demo.model.OrderModel;
import com.command.demo.model.OrderStatus;
import com.command.demo.service.command.*;
import com.command.demo.service.exchange.*;

import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.time.LocalDateTime;


@RestController
@RequestMapping("/api/orders")
public class OrderController {

    private final OrderReceiver receiver = new OrderReceiver();
    private final MockExchangeService exchangeService = new MockExchangeService();
    private final OrderCommandExecutor executor = new OrderCommandExecutor();

    // In-memory store for orders
    private final Map<UUID, OrderModel> orderStore = new HashMap<>();

    @PostMapping("/place")
    public OrderModel placeOrder(@RequestBody OrderModel order) {
        // Initialize order details
        order.setOrderId(UUID.randomUUID());
        order.setTimestamp(LocalDateTime.now());
        order.setStatus(OrderStatus.PENDING);

        // Execute the command to place the order
        PlaceOrderCommand placeCommand = new PlaceOrderCommand(receiver, order);
        executor.executeCommand(placeCommand);

        // Process the order with the mock exchange
        boolean fullyExecuted = exchangeService.executeOrder(order);

        // If the order was not fully executed, perform a rollback
        if (!fullyExecuted) {
            executor.rollbackLastCommand();
        } else {
            orderStore.put(order.getOrderId(), order);
        }

        // Return the final order details
        return order;
    }

    @PutMapping("/modify")
    public OrderModel modifyOrder(@RequestParam UUID orderId, @RequestBody OrderModel modifications) {
        OrderModel existingOrder = orderStore.get(orderId);
        if (existingOrder == null) {
            throw new IllegalArgumentException("Order not found: " + orderId);
        }
        ModifyOrderCommand modifyCommand = new ModifyOrderCommand(receiver, existingOrder, modifications);
        executor.executeCommand(modifyCommand);
        return existingOrder;
    }

    @DeleteMapping("/cancel")
    public OrderModel cancelOrder(@RequestParam UUID orderId) {
        OrderModel existingOrder = orderStore.get(orderId);
        if (existingOrder == null) {
            throw new IllegalArgumentException("Order not found: " + orderId);
        }
        CancelOrderCommand cancelCommand = new CancelOrderCommand(receiver, existingOrder);
        executor.executeCommand(cancelCommand);
        return existingOrder;
    }
}
