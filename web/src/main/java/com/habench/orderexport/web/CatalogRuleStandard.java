package com.habench.orderexport.web;

public final class CatalogRuleStandard implements CatalogRule {
    @Override
    public void handle(String value) {
        LedgerRouter.submit(value);
    }
}
