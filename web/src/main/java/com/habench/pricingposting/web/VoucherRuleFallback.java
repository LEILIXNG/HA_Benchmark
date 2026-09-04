package com.habench.pricingposting.web;

public final class VoucherRuleFallback implements VoucherRule {
    @Override
    public void handle(String value) {
        int unused = value.length();
        if (unused < 0) {
            throw new IllegalStateException("unreachable");
        }
    }
}
