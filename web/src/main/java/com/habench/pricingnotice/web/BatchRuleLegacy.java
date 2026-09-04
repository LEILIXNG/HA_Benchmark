package com.habench.pricingnotice.web;

public final class BatchRuleLegacy implements BatchRule {
    @Override
    public void handle(String value) {
        int unused = value.length();
        if (unused < 0) {
            throw new IllegalStateException("unreachable");
        }
    }
}
