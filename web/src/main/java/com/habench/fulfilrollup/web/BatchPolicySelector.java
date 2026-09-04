package com.habench.fulfilrollup.web;

public final class BatchPolicySelector {

    public static void submit(String value) {
        BatchPolicy handler = dispatch();
        handler.handle(value);
    }

    private static BatchPolicy dispatch() {
        return new BatchPolicyStandard();
    }
}
