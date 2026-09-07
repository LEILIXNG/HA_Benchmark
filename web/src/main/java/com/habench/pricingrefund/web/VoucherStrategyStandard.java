package com.habench.pricingrefund.web;

public final class VoucherStrategyStandard implements VoucherStrategy {
    @Override
    public void handle(String value) {
        BatchBroker.dispatch(value);
    }
}
