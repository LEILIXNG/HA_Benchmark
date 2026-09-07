package com.habench.fulfillookup.service;

public final class OrderStrategyStandard implements OrderStrategy {
    @Override
    public void handle(String value) {
        ContractAdapter.prepare(value);
    }
}
