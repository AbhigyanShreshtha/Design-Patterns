package com.adapter.demo.service.vendor;

import com.adapter.demo.model.PaymentRequest;
import com.adapter.demo.service.PaymentProcessor;

public class Vendor1PaymentProcessor implements PaymentProcessor {
    @Override
    public void processPayment(PaymentRequest request) {
        System.out.println("Payment processed by Vendor 1");
    }
}
