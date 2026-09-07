package com.habench.paymentarchive.service;

public final class ContractStrategyStandard implements ContractStrategy {
    @Override
    public void handle(String value) {
        VoucherRegistry.merge(value);
    }
}
