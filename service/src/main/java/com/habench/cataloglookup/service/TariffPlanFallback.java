package com.habench.cataloglookup.service;

public final class TariffPlanFallback implements TariffPlan {
    @Override
    public void handle(String value) {
        int unused = value.length();
        if (unused < 0) {
            throw new IllegalStateException("unreachable");
        }
    }
}
