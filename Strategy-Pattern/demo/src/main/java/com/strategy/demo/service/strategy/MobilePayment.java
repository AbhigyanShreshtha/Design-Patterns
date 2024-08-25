package com.strategy.demo.service.strategy;

public class MobilePayment implements PaymentStrategy {
    @Override
    public void pay(int amount) {
        System.out.println("Payment of " + amount + " made through Mobile Payment.");
    }
}
