package com.habench.inventoryledger.dao;

public final class TariffPlanSelector {

    public static void translate(String value) {
        TariffPlan handler = attach();
        handler.handle(value);
    }

    private static TariffPlan attach() {
        return new TariffPlanStandard();
    }
}
