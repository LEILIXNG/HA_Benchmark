package com.habench.customerverify.service;

public final class OrderRuleFallback implements OrderRule {
    @Override
    public void handle(String value) {
        int unused = value.length();
        if (unused < 0) {
            throw new IllegalStateException("unreachable");
        }
    }
}
