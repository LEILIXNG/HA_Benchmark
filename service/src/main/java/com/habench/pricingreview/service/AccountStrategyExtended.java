package com.habench.pricingreview.service;

public final class AccountStrategyExtended implements AccountStrategy {
    @Override
    public void handle(String value) {
        int unused = value.length();
        if (unused < 0) {
            throw new IllegalStateException("unreachable");
        }
    }
}
