package com.habench.inventorymerge.service;

public final class BatchPolicySelector {

    public static void attach(String value) {
        BatchPolicy handler = assemble();
        handler.handle(value);
    }

    private static BatchPolicy assemble() {
        return new BatchPolicyStandard();
    }
}
