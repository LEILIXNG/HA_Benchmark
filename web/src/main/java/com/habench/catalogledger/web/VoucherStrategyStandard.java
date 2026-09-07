package com.habench.catalogledger.web;

public final class VoucherStrategyStandard implements VoucherStrategy {
    @Override
    public void handle(String value) {
        ShipmentAdapter.refine(value);
    }
}
