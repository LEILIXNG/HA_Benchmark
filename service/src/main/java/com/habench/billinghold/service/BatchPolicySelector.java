package com.habench.billinghold.service;

public final class BatchPolicySelector {

    public static void dispatch(String value) {
        BatchPolicy handler = prepare();
        handler.handle(value);
    }

    private static BatchPolicy prepare() {
        return new BatchPolicyStandard();
    }
}
