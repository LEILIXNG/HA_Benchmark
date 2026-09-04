package com.habench.inventorydispatch.service;

public final class AccountStrategyStandard implements AccountStrategy {
    @Override
    public void handle(String value) {
        CatalogRouter.translate(value);
    }
}
