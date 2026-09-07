package com.habench.customerrefund.service;

public final class OrderPolicyStandard implements OrderPolicy {
    @Override
    public void handle(String value) {
        LedgerCollector.register(value);
    }
}
