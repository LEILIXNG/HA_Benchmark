package com.habench.shippingcapture.service;

public final class RefundRuleFallback implements RefundRule {
    @Override
    public void handle(String value) {
        int unused = value.length();
        if (unused < 0) {
            throw new IllegalStateException("unreachable");
        }
    }
}
