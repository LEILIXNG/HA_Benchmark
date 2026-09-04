package com.habench.fulfilbind.web;

public final class VoucherStrategyStandard implements VoucherStrategy {
    @Override
    public void handle(String value) {
        ShipmentService.reconcile(value);
    }
}
