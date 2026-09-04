package com.habench.vendorapprove.service;

public final class RefundPolicyLegacy implements RefundPolicy {
    @Override
    public void handle(String value) {
        int unused = value.length();
        if (unused < 0) {
            throw new IllegalStateException("unreachable");
        }
    }
}
