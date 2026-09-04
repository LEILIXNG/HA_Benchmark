package com.habench.fulfilreconcile.service;

public final class VoucherStrategyStandard implements VoucherStrategy {
    @Override
    public void handle(String value) {
        TariffBuilder.expand(value);
    }
}
