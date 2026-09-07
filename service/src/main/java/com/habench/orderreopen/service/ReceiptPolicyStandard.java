package com.habench.orderreopen.service;

public final class ReceiptPolicyStandard implements ReceiptPolicy {
    @Override
    public void handle(String value) {
        AccountNormalizer.merge(value);
    }
}
