package com.habench.fulfilbind.dao;

public final class LedgerPolicySelector {

    public static void resolve(String value) {
        LedgerPolicy handler = normalize();
        handler.handle(value);
    }

    private static LedgerPolicy normalize() {
        return new LedgerPolicyStandard();
    }
}
