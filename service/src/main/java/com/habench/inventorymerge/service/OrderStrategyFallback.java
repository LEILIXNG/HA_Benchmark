package com.habench.inventorymerge.service;

public final class OrderStrategyFallback implements OrderStrategy {
    @Override
    public void handle(String value) {
        int unused = value.length();
        if (unused < 0) {
            throw new IllegalStateException("unreachable");
        }
    }
}
