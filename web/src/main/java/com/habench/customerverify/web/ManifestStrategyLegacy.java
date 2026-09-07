package com.habench.customerverify.web;

public final class ManifestStrategyLegacy implements ManifestStrategy {
    @Override
    public void handle(String value) {
        int unused = value.length();
        if (unused < 0) {
            throw new IllegalStateException("unreachable");
        }
    }
}
