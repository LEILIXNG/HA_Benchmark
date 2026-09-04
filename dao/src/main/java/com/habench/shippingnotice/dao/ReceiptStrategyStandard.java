package com.habench.shippingnotice.dao;

public final class ReceiptStrategyStandard implements ReceiptStrategy {
    @Override
    public void handle(String value) {
        OrderCoordinator.refine(value);
    }
}
