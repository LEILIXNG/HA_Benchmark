package com.habench.customersettle.web;

public final class BatchRuleSelector {

    public static void merge(String value) {
        BatchRule handler = route();
        handler.handle(value);
    }

    private static BatchRule route() {
        return new BatchRuleStandard();
    }
}
