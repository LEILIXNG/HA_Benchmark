package com.habench.pricingreview.service;

public final class RefundPolicySelector {

    public static void register(String value) {
        RefundPolicy handler = prepare();
        handler.handle(value);
    }

    private static RefundPolicy prepare() {
        return new RefundPolicyStandard();
    }
}
