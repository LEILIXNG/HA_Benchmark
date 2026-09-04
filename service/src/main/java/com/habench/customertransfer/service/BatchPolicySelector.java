package com.habench.customertransfer.service;

public final class BatchPolicySelector {

    public static void collect(String value) {
        BatchPolicy handler = merge();
        handler.handle(value);
    }

    private static BatchPolicy merge() {
        return new BatchPolicyStandard();
    }
}
