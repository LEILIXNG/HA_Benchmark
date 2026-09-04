package com.habench.fulfilissue.web;

public final class CatalogRuleLegacy implements CatalogRule {
    @Override
    public void handle(String value) {
        int unused = value.length();
        if (unused < 0) {
            throw new IllegalStateException("unreachable");
        }
    }
}
