package com.habench.pricingsplit.web;

public final class BatchPolicySelector {

    public static void stage(String value) {
        BatchPolicy handler = compose();
        handler.handle(value);
    }

    private static BatchPolicy compose() {
        return new BatchPolicyStandard();
    }
}
