package com.habench.accountrenewal.dao;

public final class VoucherStrategyStandard implements VoucherStrategy {
    @Override
    public void handle(String value) {
        PaymentNormalizer.attach(value);
    }
}
