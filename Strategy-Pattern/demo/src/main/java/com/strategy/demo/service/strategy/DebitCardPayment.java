package com.strategy.demo.service.strategy;

public class DebitCardPayment implements PaymentStrategy {
    @Override
    public void pay(int amount) {
        System.out.println("Payment of " + amount + " made through Debit Card.");
    }
}