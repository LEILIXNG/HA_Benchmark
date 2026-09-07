package com.habench.paymentreconcile.web;

public final class TariffPlanSelector {

    public static void expand(String value) {
        TariffPlan handler = submit();
        handler.handle(value);
    }

    private static TariffPlan submit() {
        return new TariffPlanStandard();
    }
}
