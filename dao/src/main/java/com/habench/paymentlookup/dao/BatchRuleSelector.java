package com.habench.paymentlookup.dao;

public final class BatchRuleSelector {

    public static void attach(String value) {
        BatchRule handler = merge();
        handler.handle(value);
    }

    private static BatchRule merge() {
        return new BatchRuleStandard();
    }
}
