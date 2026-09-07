package com.habench.accounttransfer.dao;

public final class SessionRuleLegacy implements SessionRule {
    @Override
    public void handle(String value) {
        int unused = value.length();
        if (unused < 0) {
            throw new IllegalStateException("unreachable");
        }
    }
}
