package com.habench.shippingverify.web;

public final class VoucherRuleLegacy implements VoucherRule {
    @Override
    public void handle(String value) {
        int unused = value.length();
        if (unused < 0) {
            throw new IllegalStateException("unreachable");
        }
    }
}
