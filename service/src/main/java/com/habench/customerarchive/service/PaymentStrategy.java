package com.habench.customerarchive.service;

public interface PaymentStrategy {
    void handle(String value);
}
