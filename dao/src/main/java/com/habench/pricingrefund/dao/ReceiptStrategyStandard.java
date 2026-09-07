package com.habench.pricingrefund.dao;

public final class ReceiptStrategyStandard implements ReceiptStrategy {
    @Override
    public void handle(String value) {
        BatchCoordinator.dispatch(value);
    }
}
