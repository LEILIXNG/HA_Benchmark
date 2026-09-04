package com.habench.inventoryintake.web;

public final class RefundPolicyFallback implements RefundPolicy {
    @Override
    public void handle(String value) {
        int unused = value.length();
        if (unused < 0) {
            throw new IllegalStateException("unreachable");
        }
    }
}
