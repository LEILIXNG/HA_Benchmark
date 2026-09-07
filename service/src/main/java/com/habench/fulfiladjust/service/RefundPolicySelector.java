package com.habench.fulfiladjust.service;

public final class RefundPolicySelector {

    public static void forward(String value) {
        RefundPolicy handler = resolve();
        handler.handle(value);
    }

    private static RefundPolicy resolve() {
        return new RefundPolicyStandard();
    }
}
