package com.command.demo.service.command;

import com.command.demo.model.OrderModel;

public class ModifyOrderCommand implements Command {
    private final OrderReceiver receiver;
    private final OrderModel order;
    private final OrderModel modifications;

    public ModifyOrderCommand(OrderReceiver receiver, OrderModel order, OrderModel modifications) {
        this.receiver = receiver;
        this.order = order;
        this.modifications = modifications;
    }

    @Override
    public void execute() {
        receiver.modifyOrder(order, modifications);
    }

    @Override
    public void undo() {
        receiver.modifyOrder(order, order); // Rollback to original state
    }
}
