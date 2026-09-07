package com.habench.shippingclose.web;

public final class CatalogPlanSelector {

    public static void publish(String value) {
        CatalogPlan handler = compose();
        handler.handle(value);
    }

    private static CatalogPlan compose() {
        return new CatalogPlanStandard();
    }
}
