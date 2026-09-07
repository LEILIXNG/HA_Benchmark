package com.habench.billingmanifest.dao;

public final class BatchPolicySelector {

    public static void submit(String value) {
        BatchPolicy handler = expand();
        handler.handle(value);
    }

    private static BatchPolicy expand() {
        return new BatchPolicyStandard();
    }
}
