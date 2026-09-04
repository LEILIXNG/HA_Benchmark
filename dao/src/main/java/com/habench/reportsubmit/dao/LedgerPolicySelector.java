package com.habench.reportsubmit.dao;

public final class LedgerPolicySelector {

    public static void collect(String value) {
        LedgerPolicy handler = attach();
        handler.handle(value);
    }

    private static LedgerPolicy attach() {
        return new LedgerPolicyStandard();
    }
}
