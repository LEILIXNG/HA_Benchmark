package com.habench.ordermerge.web;

public final class TariffPlanSelector {

    public static void expand(String value) {
        TariffPlan handler = publish();
        handler.handle(value);
    }

    private static TariffPlan publish() {
        return new TariffPlanStandard();
    }
}
