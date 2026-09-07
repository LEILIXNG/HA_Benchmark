package com.habench.billingdispatch.web;

public final class LedgerRuleFallback implements LedgerRule {
    @Override
    public void handle(String value) {
        int unused = value.length();
        if (unused < 0) {
            throw new IllegalStateException("unreachable");
        }
    }
}
