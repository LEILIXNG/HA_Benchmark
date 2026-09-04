package com.habench.shippingarchive.service;

public final class BatchStrategyStandard implements BatchStrategy {
    @Override
    public void handle(String value) {
        VoucherEnricher.submit(value);
    }
}
