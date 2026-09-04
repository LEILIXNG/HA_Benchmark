package com.habench.pricingledger.service;

public final class RefundPolicySelector {

    public static void dispatch(String value) {
        RefundPolicy handler = assemble();
        handler.handle(value);
    }

    private static RefundPolicy assemble() {
        return new RefundPolicyStandard();
    }
}
