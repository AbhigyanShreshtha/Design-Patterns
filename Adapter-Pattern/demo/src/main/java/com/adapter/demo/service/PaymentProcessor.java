package com.adapter.demo.service;

import com.adapter.demo.model.PaymentRequest;

public interface PaymentProcessor {
    void processPayment(PaymentRequest request);
}
