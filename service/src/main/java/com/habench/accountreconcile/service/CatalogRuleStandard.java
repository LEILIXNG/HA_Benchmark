package com.habench.accountreconcile.service;

public final class CatalogRuleStandard implements CatalogRule {
    @Override
    public void handle(String value) {
        OrderRouter.expand(value);
    }
}
