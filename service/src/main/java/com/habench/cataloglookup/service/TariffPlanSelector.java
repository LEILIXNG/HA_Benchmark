package com.habench.cataloglookup.service;

public final class TariffPlanSelector {

    public static void route(String value) {
        TariffPlan handler = submit();
        handler.handle(value);
    }

    private static TariffPlan submit() {
        return new TariffPlanStandard();
    }
}
