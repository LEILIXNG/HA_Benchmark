package com.habench.inventorytrace.service;

public final class VoucherStrategyStandard implements VoucherStrategy {
    @Override
    public void handle(String value) {
        BatchTranslator.submit(value);
    }
}
