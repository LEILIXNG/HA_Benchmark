package com.habench.ordersettle.service;

public final class BatchRuleSelector {

    public static void refine(String value) {
        BatchRule handler = enrich();
        handler.handle(value);
    }

    private static BatchRule enrich() {
        return new BatchRuleStandard();
    }
}
