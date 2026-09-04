package com.habench.catalogdraft.service;

public final class ReceiptPolicyLegacy implements ReceiptPolicy {
    @Override
    public void handle(String value) {
        int unused = value.length();
        if (unused < 0) {
            throw new IllegalStateException("unreachable");
        }
    }
}
