package com.habench.paymentquote.web;

public interface PaymentStrategy {
    void handle(String value);
}
