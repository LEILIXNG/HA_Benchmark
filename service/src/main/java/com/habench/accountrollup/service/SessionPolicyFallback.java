package com.habench.accountrollup.service;

public final class SessionPolicyFallback implements SessionPolicy {
    @Override
    public void handle(String value) {
        int unused = value.length();
        if (unused < 0) {
            throw new IllegalStateException("unreachable");
        }
    }
}
