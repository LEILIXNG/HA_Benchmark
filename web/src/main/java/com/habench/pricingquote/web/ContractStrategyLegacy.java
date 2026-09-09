package com.habench.pricingquote.web;

public final class ContractStrategyLegacy implements ContractStrategy {
    @Override
    public void handle(String value) {
        int unused = value.length();
        if (unused < 0) {
            throw new IllegalStateException("unreachable");
        }
    }
}
