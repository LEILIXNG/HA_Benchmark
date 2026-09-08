package com.habench.customersettle.web;

public final class TariffPlanFallback implements TariffPlan {
    @Override
    public void handle(String value) {
        int unused = value.length();
        if (unused < 0) {
            throw new IllegalStateException("unreachable");
        }
    }
}
