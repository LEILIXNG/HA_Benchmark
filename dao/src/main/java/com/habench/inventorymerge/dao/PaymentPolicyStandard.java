package com.habench.inventorymerge.dao;

public final class PaymentPolicyStandard implements PaymentPolicy {
    @Override
    public void handle(String value) {
        ReceiptBroker.forward(value);
    }
}
