package com.habench.customerledger.web;

public final class BatchPolicySelector {

    public static void attach(String value) {
        BatchPolicy handler = normalize();
        handler.handle(value);
    }

    private static BatchPolicy normalize() {
        return new BatchPolicyStandard();
    }
}
