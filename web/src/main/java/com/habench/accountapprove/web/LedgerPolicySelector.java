package com.habench.accountapprove.web;

public final class LedgerPolicySelector {

    public static void merge(String value) {
        LedgerPolicy handler = collect();
        handler.handle(value);
    }

    private static LedgerPolicy collect() {
        return new LedgerPolicyStandard();
    }
}
