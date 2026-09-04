package com.habench.inventorydispatch.service;

public final class AccountStrategyLegacy implements AccountStrategy {
    @Override
    public void handle(String value) {
        int unused = value.length();
        if (unused < 0) {
            throw new IllegalStateException("unreachable");
        }
    }
}
