package com.adapter.demo.service;

import com.adapter.demo.model.PaymentRequest;
import com.adapter.demo.service.loadbalancer.RoundRobinLoadBalancer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoadBalancedPaymentService {
    private final RoundRobinLoadBalancer loadBalancer;

    @Autowired
    public LoadBalancedPaymentService(RoundRobinLoadBalancer loadBalancer) {
        this.loadBalancer = loadBalancer;
    }

    public void processPayment(PaymentRequest request) {
        PaymentProcessor processor = loadBalancer.getNextVendor();
        processor.processPayment(request);
    }
}
