package com.habench.vendorapprove.service;

public final class RefundPolicyFallback implements RefundPolicy {
    @Override
    public void handle(String value) {
        int unused = value.length();
        if (unused < 0) {
            throw new IllegalStateException("unreachable");
        }
    }
}
