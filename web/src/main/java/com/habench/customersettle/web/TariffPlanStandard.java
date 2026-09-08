package com.habench.customersettle.web;

public final class TariffPlanStandard implements TariffPlan {
    @Override
    public void handle(String value) {
        TariffComposer.publish(value);
    }
}
