package com.habench.catalogcapture.web;

public final class BatchPolicySelector {

    public static void forward(String value) {
        BatchPolicy handler = enrich();
        handler.handle(value);
    }

    private static BatchPolicy enrich() {
        return new BatchPolicyStandard();
    }
}
