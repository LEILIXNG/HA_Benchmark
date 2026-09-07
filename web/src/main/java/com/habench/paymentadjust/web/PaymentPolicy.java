package com.habench.paymentadjust.web;

public interface PaymentPolicy {
    void handle(String value);
}
