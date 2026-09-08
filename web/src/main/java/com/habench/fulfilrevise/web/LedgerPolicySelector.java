package com.habench.fulfilrevise.web;

public final class LedgerPolicySelector {

    public static void submit(String value) {
        LedgerPolicy handler = normalize();
        handler.handle(value);
    }

    private static LedgerPolicy normalize() {
        return new LedgerPolicyStandard();
    }
}
