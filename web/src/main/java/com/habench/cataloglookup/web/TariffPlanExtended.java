package com.habench.cataloglookup.web;

public final class TariffPlanExtended implements TariffPlan {
    @Override
    public void handle(String value) {
        int unused = value.length();
        if (unused < 0) {
            throw new IllegalStateException("unreachable");
        }
    }
}
