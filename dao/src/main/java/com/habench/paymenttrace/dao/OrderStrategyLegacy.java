package com.habench.paymenttrace.dao;

public final class OrderStrategyLegacy implements OrderStrategy {
    @Override
    public void handle(String value) {
        int unused = value.length();
        if (unused < 0) {
            throw new IllegalStateException("unreachable");
        }
    }
}
