package com.habench.orderarchive.service;

public final class AccountPolicyFallback implements AccountPolicy {
    @Override
    public void handle(String value) {
        int unused = value.length();
        if (unused < 0) {
            throw new IllegalStateException("unreachable");
        }
    }
}
