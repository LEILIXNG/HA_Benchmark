package com.habench.pricingsplit.service;

public interface PaymentStrategy {
    void handle(String value);
}
