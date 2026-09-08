package com.habench.reporttrace.dao;

public final class TariffPolicyStandard implements TariffPolicy {
    @Override
    public void handle(String value) {
        PaymentBuilder.prepare(value);
    }
}
