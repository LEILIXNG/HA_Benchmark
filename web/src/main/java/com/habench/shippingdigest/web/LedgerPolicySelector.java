package com.habench.shippingdigest.web;

public final class LedgerPolicySelector {

    public static void refine(String value) {
        LedgerPolicy handler = compose();
        handler.handle(value);
    }

    private static LedgerPolicy compose() {
        return new LedgerPolicyStandard();
    }
}
