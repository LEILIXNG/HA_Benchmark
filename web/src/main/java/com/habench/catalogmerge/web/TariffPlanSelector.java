package com.habench.catalogmerge.web;

public final class TariffPlanSelector {

    public static void translate(String value) {
        TariffPlan handler = dispatch();
        handler.handle(value);
    }

    private static TariffPlan dispatch() {
        return new TariffPlanStandard();
    }
}
