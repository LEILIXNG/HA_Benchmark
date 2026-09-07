package com.habench.pricingsettlequeue.web;

public final class VoucherPolicyLegacy implements VoucherPolicy {
    @Override
    public void handle(String value) {
        int unused = value.length();
        if (unused < 0) {
            throw new IllegalStateException("unreachable");
        }
    }
}
