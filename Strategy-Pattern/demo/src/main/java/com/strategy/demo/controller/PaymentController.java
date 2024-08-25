package com.strategy.demo.controller;

import com.strategy.demo.model.PaymentRequest;
import com.strategy.demo.service.*;
import com.strategy.demo.service.strategy.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/payment")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @PostMapping("/process")
    public String processPayment(@RequestBody PaymentRequest request) {
        PaymentStrategy strategy;

        switch (request.getMethod().toLowerCase()) {
            case "creditcard":
                strategy = new CreditCardPayment();
                break;
            case "debitcard":
                strategy = new DebitCardPayment();
                break;
            case "netbanking":
                strategy = new NetBankingPayment();
                break;
            case "crypto":
                strategy = new CryptoPayment();
                break;
            case "mobile":
                strategy = new MobilePayment();
                break;
            default:
                return "Invalid payment method";
        }

        paymentService.setPaymentStrategy(strategy);
        paymentService.processPayment(request.getAmount());
        return "Payment processed successfully";
    }
}
