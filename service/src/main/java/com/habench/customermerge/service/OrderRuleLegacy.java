package com.habench.customermerge.service;

public final class OrderRuleLegacy implements OrderRule {
    @Override
    public void handle(String value) {
        int unused = value.length();
        if (unused < 0) {
            throw new IllegalStateException("unreachable");
        }
    }
}
