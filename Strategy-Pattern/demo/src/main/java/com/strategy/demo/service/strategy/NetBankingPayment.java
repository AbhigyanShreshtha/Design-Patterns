package com.strategy.demo.service.strategy;

public class NetBankingPayment implements PaymentStrategy {
    @Override
    public void pay(int amount) {
        System.out.println("Payment of " + amount + " made through Net Banking.");
    }
}
