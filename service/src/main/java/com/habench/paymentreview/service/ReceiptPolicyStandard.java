package com.habench.paymentreview.service;

public final class ReceiptPolicyStandard implements ReceiptPolicy {
    @Override
    public void handle(String value) {
        BatchResolver.prepare(value);
    }
}
