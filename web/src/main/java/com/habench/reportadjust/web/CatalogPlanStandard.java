package com.habench.reportadjust.web;

public final class CatalogPlanStandard implements CatalogPlan {
    @Override
    public void handle(String value) {
        RefundRouter.route(value);
    }
}
