package com.habench.accountreopen.dao;

public final class VoucherStrategyStandard implements VoucherStrategy {
    @Override
    public void handle(String value) {
        SessionNormalizer.submit(value);
    }
}
