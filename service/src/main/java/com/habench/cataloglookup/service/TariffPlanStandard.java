package com.habench.cataloglookup.service;

public final class TariffPlanStandard implements TariffPlan {
    @Override
    public void handle(String value) {
        VoucherCoordinator.submit(value);
    }
}
