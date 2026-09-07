package com.habench.catalogmerge.web;

public final class TariffPlanStandard implements TariffPlan {
    @Override
    public void handle(String value) {
        BatchAdapter.compose(value);
    }
}
