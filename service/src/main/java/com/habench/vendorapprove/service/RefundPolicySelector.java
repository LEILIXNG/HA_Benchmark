package com.habench.vendorapprove.service;

public final class RefundPolicySelector {

    public static void compose(String value) {
        RefundPolicy handler = route();
        handler.handle(value);
    }

    private static RefundPolicy route() {
        return new RefundPolicyStandard();
    }
}
