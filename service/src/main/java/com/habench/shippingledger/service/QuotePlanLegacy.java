package com.habench.shippingledger.service;

public final class QuotePlanLegacy implements QuotePlan {
    @Override
    public void handle(String value) {
        int unused = value.length();
        if (unused < 0) {
            throw new IllegalStateException("unreachable");
        }
    }
}
