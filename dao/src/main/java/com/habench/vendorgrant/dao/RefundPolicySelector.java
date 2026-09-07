package com.habench.vendorgrant.dao;

public final class RefundPolicySelector {

    public static void stage(String value) {
        RefundPolicy handler = prepare();
        handler.handle(value);
    }

    private static RefundPolicy prepare() {
        return new RefundPolicyStandard();
    }
}
