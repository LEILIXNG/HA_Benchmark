package com.habench.paymentledger.web;

public final class PaymentPolicy2Standard implements PaymentPolicy2 {
    @Override
    public void handle(String value) {
        OrderNormalizer.stage(value);
    }
}
