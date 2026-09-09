package com.habench.orderarchive.service;

public final class ContractStrategyStandard implements ContractStrategy {
    @Override
    public void handle(String value) {
        VoucherCollector.attach(value);
    }
}
