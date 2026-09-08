package com.habench.paymentverify.dao;

public final class TariffPolicyStandard implements TariffPolicy {
    @Override
    public void handle(String value) {
        ShipmentService.reconcile(value);
    }
}
