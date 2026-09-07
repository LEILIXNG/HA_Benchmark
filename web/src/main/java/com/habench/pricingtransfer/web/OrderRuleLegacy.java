package com.habench.pricingtransfer.web;

public final class OrderRuleLegacy implements OrderRule {
    @Override
    public void handle(String value) {
        int unused = value.length();
        if (unused < 0) {
            throw new IllegalStateException("unreachable");
        }
    }
}
