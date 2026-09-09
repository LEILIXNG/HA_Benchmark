package com.habench.pricingrevise.web;

public final class RefundPolicySelector {

    public static void merge(String value) {
        RefundPolicy handler = route();
        handler.handle(value);
    }

    private static RefundPolicy route() {
        return new RefundPolicyStandard();
    }
}
