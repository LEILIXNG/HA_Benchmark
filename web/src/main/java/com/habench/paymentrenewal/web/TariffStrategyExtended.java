package com.habench.paymentrenewal.web;

public final class TariffStrategyExtended implements TariffStrategy {
    @Override
    public void handle(String value) {
        int unused = value.length();
        if (unused < 0) {
            throw new IllegalStateException("unreachable");
        }
    }
}
