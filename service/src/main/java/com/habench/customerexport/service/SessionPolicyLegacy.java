package com.habench.customerexport.service;

public final class SessionPolicyLegacy implements SessionPolicy {
    @Override
    public void handle(String value) {
        int unused = value.length();
        if (unused < 0) {
            throw new IllegalStateException("unreachable");
        }
    }
}
