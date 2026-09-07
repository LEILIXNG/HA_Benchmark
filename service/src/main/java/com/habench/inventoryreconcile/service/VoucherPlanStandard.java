package com.habench.inventoryreconcile.service;

public final class VoucherPlanStandard implements VoucherPlan {
    @Override
    public void handle(String value) {
        ShipmentService.collect(value);
    }
}
