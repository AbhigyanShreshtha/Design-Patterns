package com.command.demo.service.command;

import com.command.demo.model.OrderModel;
import com.command.demo.model.OrderStatus;

public class OrderReceiver {

    public void placeOrder(OrderModel order) {
        System.out.println("Order placed: " + order);
    }

    public void modifyOrder(OrderModel order, OrderModel modifications) {
        order.setPrice(modifications.getPrice());
        order.setQuantity(modifications.getQuantity());
        System.out.println("Order modified: " + order);
    }

    public void cancelOrder(OrderModel order) {
        order.setStatus(OrderStatus.CANCELLED);
        System.out.println("Order cancelled: " + order);
    }
}
