package com.habench.paymentdraft.service;

public final class RefundStrategyStandard implements RefundStrategy {
    @Override
    public void handle(String value) {
        BatchCoordinator.merge(value);
    }
}
