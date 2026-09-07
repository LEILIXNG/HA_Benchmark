package com.habench.shippingbind.service;

public final class VoucherStrategyStandard implements VoucherStrategy {
    @Override
    public void handle(String value) {
        CatalogCollector.dispatch(value);
    }
}
