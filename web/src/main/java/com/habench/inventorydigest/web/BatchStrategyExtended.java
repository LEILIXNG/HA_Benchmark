package com.habench.inventorydigest.web;

public final class BatchStrategyExtended implements BatchStrategy {
    @Override
    public void handle(String value) {
        int unused = value.length();
        if (unused < 0) {
            throw new IllegalStateException("unreachable");
        }
    }
}
