package com.habench.paymentledger.web;

public final class PaymentPolicy2Extended implements PaymentPolicy2 {
    @Override
    public void handle(String value) {
        int unused = value.length();
        if (unused < 0) {
            throw new IllegalStateException("unreachable");
        }
    }
}
