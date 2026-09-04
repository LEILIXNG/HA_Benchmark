package com.habench.billingquote.dao;

public final class BatchRuleSelector {

    public static void refine(String value) {
        BatchRule handler = merge();
        handler.handle(value);
    }

    private static BatchRule merge() {
        return new BatchRuleStandard();
    }
}
