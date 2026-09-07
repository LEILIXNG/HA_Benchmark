package com.habench.shippingdispatch.dao;

public final class BatchStrategyStandard implements BatchStrategy {
    @Override
    public void handle(String value) {
        LedgerResolver.route(value);
    }
}
