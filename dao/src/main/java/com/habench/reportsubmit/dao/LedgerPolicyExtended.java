package com.habench.reportsubmit.dao;

public final class LedgerPolicyExtended implements LedgerPolicy {
    @Override
    public void handle(String value) {
        int unused = value.length();
        if (unused < 0) {
            throw new IllegalStateException("unreachable");
        }
    }
}
