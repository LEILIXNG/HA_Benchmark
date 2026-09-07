package com.habench.shippingdigest.dao;

public final class PaymentPolicyStandard implements PaymentPolicy {
    @Override
    public void handle(String value) {
        ReceiptBroker.forward(value);
    }
}
