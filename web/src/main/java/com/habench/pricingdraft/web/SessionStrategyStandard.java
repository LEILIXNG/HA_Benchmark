package com.habench.pricingdraft.web;

public final class SessionStrategyStandard implements SessionStrategy {
    @Override
    public void handle(String value) {
        BatchCollector.reconcile(value);
    }
}
