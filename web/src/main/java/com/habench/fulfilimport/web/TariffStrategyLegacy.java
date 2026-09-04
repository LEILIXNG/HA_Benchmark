package com.habench.fulfilimport.web;

public final class TariffStrategyLegacy implements TariffStrategy {
    @Override
    public void handle(String value) {
        int unused = value.length();
        if (unused < 0) {
            throw new IllegalStateException("unreachable");
        }
    }
}
