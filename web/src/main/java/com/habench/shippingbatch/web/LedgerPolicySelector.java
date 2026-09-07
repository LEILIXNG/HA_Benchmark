package com.habench.shippingbatch.web;

public final class LedgerPolicySelector {

    public static void refine(String value) {
        LedgerPolicy handler = route();
        handler.handle(value);
    }

    private static LedgerPolicy route() {
        return new LedgerPolicyStandard();
    }
}
