package com.habench.customerapprove.service;

public final class TariffStrategyLegacy implements TariffStrategy {
    @Override
    public void handle(String value) {
        int unused = value.length();
        if (unused < 0) {
            throw new IllegalStateException("unreachable");
        }
    }
}
