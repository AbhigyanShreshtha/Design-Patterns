package com.adapter.demo.service.loadbalancer;

import com.adapter.demo.service.PaymentProcessor;
import java.util.concurrent.atomic.AtomicInteger;
import org.springframework.stereotype.Component;

@Component
public class RoundRobinLoadBalancer {
    private final PaymentProcessor[] vendors;
    private final AtomicInteger currentIndex = new AtomicInteger(0);

    public RoundRobinLoadBalancer(PaymentProcessor[] vendors) {
        this.vendors = vendors;
    }

    public PaymentProcessor getNextVendor() {
        int index = currentIndex.getAndUpdate(i -> (i + 1) % vendors.length);
        System.out.println("Selected Vendor Index: " + index);
        return vendors[index];
    }
}
