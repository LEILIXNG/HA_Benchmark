package com.habench.vendordispatch.web;

public final class TariffPlanSelector {

    public static void reconcile(String value) {
        TariffPlan handler = compose();
        handler.handle(value);
    }

    private static TariffPlan compose() {
        return new TariffPlanStandard();
    }
}
