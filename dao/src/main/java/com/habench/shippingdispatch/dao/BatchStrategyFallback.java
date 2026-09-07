package com.habench.shippingdispatch.dao;

public final class BatchStrategyFallback implements BatchStrategy {
    @Override
    public void handle(String value) {
        int unused = value.length();
        if (unused < 0) {
            throw new IllegalStateException("unreachable");
        }
    }
}
