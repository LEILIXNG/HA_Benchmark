package com.habench.vendorrevise.web;

public final class OrderPolicyLegacy implements OrderPolicy {
    @Override
    public void handle(String value) {
        int unused = value.length();
        if (unused < 0) {
            throw new IllegalStateException("unreachable");
        }
    }
}
