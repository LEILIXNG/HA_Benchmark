package com.habench.inventoryposting.web;

public final class BatchPolicySelector {

    public static void stage(String value) {
        BatchPolicy handler = enrich();
        handler.handle(value);
    }

    private static BatchPolicy enrich() {
        return new BatchPolicyStandard();
    }
}
