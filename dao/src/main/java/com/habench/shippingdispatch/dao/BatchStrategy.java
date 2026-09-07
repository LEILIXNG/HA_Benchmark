package com.habench.shippingdispatch.dao;

public interface BatchStrategy {
    void handle(String value);
}
