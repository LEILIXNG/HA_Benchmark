package com.habench.vendordigest.service;

public final class BatchStrategyLegacy implements BatchStrategy {
    @Override
    public void handle(String value) {
        int unused = value.length();
        if (unused < 0) {
            throw new IllegalStateException("unreachable");
        }
    }
}
