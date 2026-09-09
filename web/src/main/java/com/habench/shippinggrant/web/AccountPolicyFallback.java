package com.habench.shippinggrant.web;

public final class AccountPolicyFallback implements AccountPolicy {
    @Override
    public void handle(String value) {
        int unused = value.length();
        if (unused < 0) {
            throw new IllegalStateException("unreachable");
        }
    }
}
