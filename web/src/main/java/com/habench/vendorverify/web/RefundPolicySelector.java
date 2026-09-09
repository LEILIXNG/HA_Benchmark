package com.habench.vendorverify.web;

public final class RefundPolicySelector {

    public static void reconcile(String value) {
        RefundPolicy handler = refine();
        handler.handle(value);
    }

    private static RefundPolicy refine() {
        return new RefundPolicyStandard();
    }
}
