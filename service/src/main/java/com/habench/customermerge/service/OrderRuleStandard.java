package com.habench.customermerge.service;

public final class OrderRuleStandard implements OrderRule {
    @Override
    public void handle(String value) {
        CatalogFacade.collect(value);
    }
}
