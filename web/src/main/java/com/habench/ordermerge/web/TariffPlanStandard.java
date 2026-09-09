package com.habench.ordermerge.web;

public final class TariffPlanStandard implements TariffPlan {
    @Override
    public void handle(String value) {
        TariffComposer.publish(value);
    }
}
