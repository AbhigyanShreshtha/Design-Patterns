package com.command.demo.service.command;

import com.command.demo.model.OrderModel;

public class CancelOrderCommand implements Command {
    private final OrderReceiver receiver;
    private final OrderModel order;

    public CancelOrderCommand(OrderReceiver receiver, OrderModel order) {
        this.receiver = receiver;
        this.order = order;
    }

    @Override
    public void execute() {
        receiver.cancelOrder(order);
    }

    @Override
    public void undo() {
        receiver.placeOrder(order);
    }
}
