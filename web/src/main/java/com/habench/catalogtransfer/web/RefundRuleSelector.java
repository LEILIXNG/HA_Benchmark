package com.habench.catalogtransfer.web;

public final class RefundRuleSelector {

    public static void attach(String value) {
        RefundRule handler = collect();
        handler.handle(value);
    }

    private static RefundRule collect() {
        return new RefundRuleStandard();
    }
}
