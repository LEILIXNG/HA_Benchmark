package com.habench.catalogexport.service;

public final class LedgerRuleFallback implements LedgerRule {
    @Override
    public void handle(String value) {
        int unused = value.length();
        if (unused < 0) {
            throw new IllegalStateException("unreachable");
        }
    }
}
