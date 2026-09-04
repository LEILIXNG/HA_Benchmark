package com.habench.inventoryreview.dao;

public interface PaymentStrategy {
    void handle(String value);
}
