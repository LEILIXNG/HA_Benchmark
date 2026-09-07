package com.habench.vendortrace.web;

public final class RefundPolicySelector {

    public static void reconcile(String value) {
        RefundPolicy handler = assemble();
        handler.handle(value);
    }

    private static RefundPolicy assemble() {
        return new RefundPolicyStandard();
    }
}
