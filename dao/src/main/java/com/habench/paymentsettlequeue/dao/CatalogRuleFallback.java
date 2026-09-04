package com.habench.paymentsettlequeue.dao;

public final class CatalogRuleFallback implements CatalogRule {
    @Override
    public void handle(String value) {
        int unused = value.length();
        if (unused < 0) {
            throw new IllegalStateException("unreachable");
        }
    }
}
