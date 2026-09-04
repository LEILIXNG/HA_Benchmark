package com.habench.catalogmerge.service;

public final class AccountRuleFallback implements AccountRule {
    @Override
    public void handle(String value) {
        int unused = value.length();
        if (unused < 0) {
            throw new IllegalStateException("unreachable");
        }
    }
}
