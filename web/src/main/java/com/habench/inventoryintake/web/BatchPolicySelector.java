package com.habench.inventoryintake.web;

public final class BatchPolicySelector {

    public static void dispatch(String value) {
        BatchPolicy handler = assemble();
        handler.handle(value);
    }

    private static BatchPolicy assemble() {
        return new BatchPolicyStandard();
    }
}
