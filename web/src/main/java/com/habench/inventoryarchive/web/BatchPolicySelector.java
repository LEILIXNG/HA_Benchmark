package com.habench.inventoryarchive.web;

public final class BatchPolicySelector {

    public static void forward(String value) {
        BatchPolicy handler = refine();
        handler.handle(value);
    }

    private static BatchPolicy refine() {
        return new BatchPolicyStandard();
    }
}
