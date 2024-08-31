package com.command.demo.service.command;

import com.command.demo.model.OrderModel;

public class PlaceOrderCommand implements Command {
    private final OrderReceiver receiver;
    private final OrderModel order;

    public PlaceOrderCommand(OrderReceiver receiver, OrderModel order) {
        this.receiver = receiver;
        this.order = order;
    }

    @Override
    public void execute() {
        receiver.placeOrder(order);
    }

    @Override
    public void undo() {
        receiver.cancelOrder(order);
    }
}
