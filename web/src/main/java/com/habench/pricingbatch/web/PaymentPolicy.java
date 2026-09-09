package com.habench.pricingbatch.web;

public interface PaymentPolicy {
    void handle(String value);
}
