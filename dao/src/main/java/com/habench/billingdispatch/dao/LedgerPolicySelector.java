package com.habench.billingdispatch.dao;

public final class LedgerPolicySelector {

    public static void prepare(String value) {
        LedgerPolicy handler = merge();
        handler.handle(value);
    }

    private static LedgerPolicy merge() {
        return new LedgerPolicyStandard();
    }
}
