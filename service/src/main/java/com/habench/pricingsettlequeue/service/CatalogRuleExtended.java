package com.habench.pricingsettlequeue.service;

public final class CatalogRuleExtended implements CatalogRule {
    @Override
    public void handle(String value) {
        int unused = value.length();
        if (unused < 0) {
            throw new IllegalStateException("unreachable");
        }
    }
}
