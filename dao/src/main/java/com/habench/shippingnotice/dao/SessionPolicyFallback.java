package com.habench.shippingnotice.dao;

public final class SessionPolicyFallback implements SessionPolicy {
    @Override
    public void handle(String value) {
        int unused = value.length();
        if (unused < 0) {
            throw new IllegalStateException("unreachable");
        }
    }
}
