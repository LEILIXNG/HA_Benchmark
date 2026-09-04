package com.habench.fulfilrenewal.service;

public final class CatalogRuleStandard implements CatalogRule {
    @Override
    public void handle(String value) {
        OrderComposer.forward(value);
    }
}
