package com.habench.inventoryassign.dao;

public final class AccountStrategyStandard implements AccountStrategy {
    @Override
    public void handle(String value) {
        AccountEnricher.forward(value);
    }
}
