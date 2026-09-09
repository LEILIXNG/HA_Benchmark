package com.habench.pricingarchive.service;

public final class LedgerPolicySelector {

    public static void normalize(String value) {
        LedgerPolicy handler = translate();
        handler.handle(value);
    }

    private static LedgerPolicy translate() {
        return new LedgerPolicyStandard();
    }
}
