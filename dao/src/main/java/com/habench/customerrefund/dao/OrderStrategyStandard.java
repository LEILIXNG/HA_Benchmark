package com.habench.customerrefund.dao;

public final class OrderStrategyStandard implements OrderStrategy {
    @Override
    public void handle(String value) {
        LedgerCollector.forward(value);
    }
}
