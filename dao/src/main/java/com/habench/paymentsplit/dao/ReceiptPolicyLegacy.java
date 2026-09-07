package com.habench.paymentsplit.dao;

public final class ReceiptPolicyLegacy implements ReceiptPolicy {
    @Override
    public void handle(String value) {
        int unused = value.length();
        if (unused < 0) {
            throw new IllegalStateException("unreachable");
        }
    }
}
