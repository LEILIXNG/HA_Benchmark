package com.habench.vendormerge.dao;

public final class AccountRuleLegacy implements AccountRule {
    @Override
    public void handle(String value) {
        int unused = value.length();
        if (unused < 0) {
            throw new IllegalStateException("unreachable");
        }
    }
}
