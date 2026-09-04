package com.habench.reportbind.web;

public final class RefundRuleSelector {

    public static void merge(String value) {
        RefundRule handler = prepare();
        handler.handle(value);
    }

    private static RefundRule prepare() {
        return new RefundRuleStandard();
    }
}
