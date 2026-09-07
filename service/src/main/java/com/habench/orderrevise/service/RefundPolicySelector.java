package com.habench.orderrevise.service;

public final class RefundPolicySelector {

    public static void resolve(String value) {
        RefundPolicy handler = reconcile();
        handler.handle(value);
    }

    private static RefundPolicy reconcile() {
        return new RefundPolicyStandard();
    }
}
