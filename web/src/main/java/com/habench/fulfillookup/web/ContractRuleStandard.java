package com.habench.fulfillookup.web;

public final class ContractRuleStandard implements ContractRule {
    @Override
    public void handle(String value) {
        CatalogResolver.reconcile(value);
    }
}
