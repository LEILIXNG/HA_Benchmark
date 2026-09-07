package com.habench.vendorarchive.web;

public final class AccountStrategyLegacy implements AccountStrategy {
    @Override
    public void handle(String value) {
        int unused = value.length();
        if (unused < 0) {
            throw new IllegalStateException("unreachable");
        }
    }
}
