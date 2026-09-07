package com.habench.fulfiladjust.service;

public final class RefundPolicyExtended implements RefundPolicy {
    @Override
    public void handle(String value) {
        int unused = value.length();
        if (unused < 0) {
            throw new IllegalStateException("unreachable");
        }
    }
}
