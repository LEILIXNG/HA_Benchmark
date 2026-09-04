package com.habench.vendorrelease.web;

public final class TariffStrategyFallback implements TariffStrategy {
    @Override
    public void handle(String value) {
        int unused = value.length();
        if (unused < 0) {
            throw new IllegalStateException("unreachable");
        }
    }
}
