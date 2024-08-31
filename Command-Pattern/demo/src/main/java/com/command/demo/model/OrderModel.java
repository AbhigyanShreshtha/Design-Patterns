package com.command.demo.model;

import java.util.UUID;
import java.time.LocalDateTime; // Make sure this is imported

public class OrderModel {
    private UUID orderId;
    private String stockName;
    private double price;
    private int quantity;
    private LocalDateTime timestamp;
    private OrderStatus status;
    private OrderType orderType;

    public OrderModel() {
        // Default constructor
    }

    public OrderModel(String stockName, double price, int quantity, OrderType orderType) {
        this.orderId = UUID.randomUUID();
        this.stockName = stockName;
        this.price = price;
        this.quantity = quantity;
        this.timestamp = LocalDateTime.now(); // Assign current timestamp
        this.status = OrderStatus.PENDING;
        this.orderType = orderType;
    }

    // Getters and Setters
    public UUID getOrderId() {
        return orderId;
    }

    public void setOrderId(UUID orderId) {
        this.orderId = orderId;
    }

    public String getStockName() {
        return stockName;
    }

    public void setStockName(String stockName) {
        this.stockName = stockName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public OrderType getOrderType() {
        return orderType;
    }

    public void setOrderType(OrderType orderType) {
        this.orderType = orderType;
    }

    @Override
    public String toString() {
        return "OrderModel{" +
                "orderId=" + orderId +
                ", stockName='" + stockName + '\'' +
                ", price=" + price +
                ", quantity=" + quantity +
                ", timestamp=" + timestamp +
                ", status=" + status +
                ", orderType=" + orderType +
                '}';
    }
}
