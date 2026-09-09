package com.habench.ordersync.web;

public final class BatchRuleStandard implements BatchRule {
    @Override
    public void handle(String value) {
        ContractResolver.reconcile(value);
    }
}
