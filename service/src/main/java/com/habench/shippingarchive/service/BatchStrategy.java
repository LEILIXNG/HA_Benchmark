package com.habench.shippingarchive.service;

public interface BatchStrategy {
    void handle(String value);
}
