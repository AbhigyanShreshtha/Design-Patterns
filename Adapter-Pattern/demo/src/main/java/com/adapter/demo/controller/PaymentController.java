package com.adapter.demo.controller;

import com.adapter.demo.model.PaymentRequest;
import com.adapter.demo.service.LoadBalancedPaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/payment")
public class PaymentController {

    private final LoadBalancedPaymentService paymentService;

    @Autowired
    public PaymentController(LoadBalancedPaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @PostMapping("/makePayment")
    public String makePayment(@RequestBody PaymentRequest request) {
        paymentService.processPayment(request);
        return "Payment processing initiated";
    }
}
