package com.habench.fulfilnotice.web;

public final class RefundPolicySelector {

    public static void stage(String value) {
        RefundPolicy handler = forward();
        handler.handle(value);
    }

    private static RefundPolicy forward() {
        return new RefundPolicyStandard();
    }
}
