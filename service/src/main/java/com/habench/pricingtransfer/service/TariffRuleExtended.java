package com.habench.pricingtransfer.service;

public final class TariffRuleExtended implements TariffRule {
    @Override
    public void handle(String value) {
        int unused = value.length();
        if (unused < 0) {
            throw new IllegalStateException("unreachable");
        }
    }
}
