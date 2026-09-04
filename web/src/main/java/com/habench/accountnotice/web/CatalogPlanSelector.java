package com.habench.accountnotice.web;

public final class CatalogPlanSelector {

    public static void dispatch(String value) {
        CatalogPlan handler = assemble();
        handler.handle(value);
    }

    private static CatalogPlan assemble() {
        return new CatalogPlanStandard();
    }
}
