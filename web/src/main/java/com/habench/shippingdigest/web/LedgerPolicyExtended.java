package com.habench.shippingdigest.web;

public final class LedgerPolicyExtended implements LedgerPolicy {
    @Override
    public void handle(String value) {
        int unused = value.length();
        if (unused < 0) {
            throw new IllegalStateException("unreachable");
        }
    }
}
