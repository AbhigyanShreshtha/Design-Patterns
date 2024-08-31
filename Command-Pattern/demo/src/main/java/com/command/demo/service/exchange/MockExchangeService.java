package com.command.demo.service.exchange;

import com.command.demo.model.*;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class MockExchangeService {

    private int orderCounter = 0;
    private final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);

    public boolean executeOrder(OrderModel order) {
        orderCounter++;

        if (order.getOrderType() == OrderType.LIMIT) {
            scheduler.schedule(() -> processOrder(order), 30, TimeUnit.SECONDS);
            return true; // Assume success and handle the result in the scheduled task
        } else {
            return processOrder(order);
        }
    }

    private boolean processOrder(OrderModel order) {
        if (orderCounter % 3 == 0) {
            int fulfilledQuantity = order.getQuantity() - 1; // Partially fulfill the order
            order.setQuantity(fulfilledQuantity);
            order.setStatus(OrderStatus.FAILURE);
            System.out.println("Order partially executed: " + order);
            return false;
        } else {
            order.setStatus(OrderStatus.SUCCESS);
            System.out.println("Order fully executed: " + order);
            return true;
        }
    }
}
