package com.habench.reportreview.web;

public final class BatchPolicySelector {

    public static void translate(String value) {
        BatchPolicy handler = collect();
        handler.handle(value);
    }

    private static BatchPolicy collect() {
        return new BatchPolicyStandard();
    }
}
