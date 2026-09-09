package com.habench.paymentcapture.service;

public interface PaymentStrategy {
    void handle(String value);
}
