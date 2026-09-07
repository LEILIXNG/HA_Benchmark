package com.habench.reportimport.service;

public final class TariffPlanSelector {

    public static void prepare(String value) {
        TariffPlan handler = expand();
        handler.handle(value);
    }

    private static TariffPlan expand() {
        return new TariffPlanStandard();
    }
}
