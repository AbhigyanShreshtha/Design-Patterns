package com.strategy.demo.service.strategy;

public class CryptoPayment implements PaymentStrategy {
    @Override
    public void pay(int amount) {
        System.out.println("Payment of " + amount + " made through Crypto.");
    }
}
