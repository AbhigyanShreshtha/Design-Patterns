package com.adapter.demo.config;

import com.adapter.demo.service.PaymentProcessor;
import com.adapter.demo.service.loadbalancer.RoundRobinLoadBalancer;
import com.adapter.demo.service.vendor.Vendor1PaymentProcessor;
import com.adapter.demo.service.vendor.Vendor2PaymentProcessor;
import com.adapter.demo.service.vendor.Vendor3PaymentProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public PaymentProcessor[] paymentProcessors() {
        return new PaymentProcessor[]{
            new Vendor1PaymentProcessor(),
            new Vendor2PaymentProcessor(),
            new Vendor3PaymentProcessor()
        };
    }

    @Bean
    public RoundRobinLoadBalancer roundRobinLoadBalancer(PaymentProcessor[] vendors) {
        return new RoundRobinLoadBalancer(vendors);
    }
}
