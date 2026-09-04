package com.habench.accountreconcile.service;

public final class BundleStrategyLegacy implements BundleStrategy {
    @Override
    public void handle(String value) {
        int unused = value.length();
        if (unused < 0) {
            throw new IllegalStateException("unreachable");
        }
    }
}
