package com.habench.fulfilquote.dao;

public final class AccountPolicyLegacy implements AccountPolicy {
    @Override
    public void handle(String value) {
        int unused = value.length();
        if (unused < 0) {
            throw new IllegalStateException("unreachable");
        }
    }
}
