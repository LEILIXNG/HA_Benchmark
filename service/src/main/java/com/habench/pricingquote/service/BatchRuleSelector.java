package com.habench.pricingquote.service;

public final class BatchRuleSelector {

    public static void attach(String value) {
        BatchRule handler = reconcile();
        handler.handle(value);
    }

    private static BatchRule reconcile() {
        return new BatchRuleStandard();
    }
}
