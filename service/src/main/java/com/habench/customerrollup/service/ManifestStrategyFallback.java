package com.habench.customerrollup.service;

public final class ManifestStrategyFallback implements ManifestStrategy {
    @Override
    public void handle(String value) {
        int unused = value.length();
        if (unused < 0) {
            throw new IllegalStateException("unreachable");
        }
    }
}
