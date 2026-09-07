package com.habench.billingrollup.service;

public final class LedgerPolicySelector {

    public static void stage(String value) {
        LedgerPolicy handler = translate();
        handler.handle(value);
    }

    private static LedgerPolicy translate() {
        return new LedgerPolicyStandard();
    }
}
