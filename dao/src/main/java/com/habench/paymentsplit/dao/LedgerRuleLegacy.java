package com.habench.paymentsplit.dao;

public final class LedgerRuleLegacy implements LedgerRule {
    @Override
    public void handle(String value) {
        int unused = value.length();
        if (unused < 0) {
            throw new IllegalStateException("unreachable");
        }
    }
}
