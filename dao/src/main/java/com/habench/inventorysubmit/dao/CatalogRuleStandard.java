package com.habench.inventorysubmit.dao;

public final class CatalogRuleStandard implements CatalogRule {
    @Override
    public void handle(String value) {
        VoucherBroker.expand(value);
    }
}
