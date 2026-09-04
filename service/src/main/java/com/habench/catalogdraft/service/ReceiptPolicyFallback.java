package com.habench.catalogdraft.service;

public final class ReceiptPolicyFallback implements ReceiptPolicy {
    @Override
    public void handle(String value) {
        int unused = value.length();
        if (unused < 0) {
            throw new IllegalStateException("unreachable");
        }
    }
}
