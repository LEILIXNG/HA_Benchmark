package com.habench.billingbind.dao;

public final class VoucherStrategyStandard implements VoucherStrategy {
    @Override
    public void handle(String value) {
        CatalogService.expand(value);
    }
}
