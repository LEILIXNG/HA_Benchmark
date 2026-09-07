package com.habench.inventoryissue.service;

public final class AccountStrategyStandard implements AccountStrategy {
    @Override
    public void handle(String value) {
        LedgerRegistry.route(value);
    }
}
