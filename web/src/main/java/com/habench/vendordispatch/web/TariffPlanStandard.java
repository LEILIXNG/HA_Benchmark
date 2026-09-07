package com.habench.vendordispatch.web;

public final class TariffPlanStandard implements TariffPlan {
    @Override
    public void handle(String value) {
        CatalogAdapter.stage(value);
    }
}
