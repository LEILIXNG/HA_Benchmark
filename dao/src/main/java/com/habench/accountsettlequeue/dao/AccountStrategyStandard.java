package com.habench.accountsettlequeue.dao;

public final class AccountStrategyStandard implements AccountStrategy {
    @Override
    public void handle(String value) {
        CatalogEnricher.submit(value);
    }
}
