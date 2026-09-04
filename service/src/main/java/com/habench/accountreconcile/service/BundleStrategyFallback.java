package com.habench.accountreconcile.service;

public final class BundleStrategyFallback implements BundleStrategy {
    @Override
    public void handle(String value) {
        int unused = value.length();
        if (unused < 0) {
            throw new IllegalStateException("unreachable");
        }
    }
}
