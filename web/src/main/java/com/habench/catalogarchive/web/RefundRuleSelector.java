package com.habench.catalogarchive.web;

public final class RefundRuleSelector {

    public static void resolve(String value) {
        RefundRule handler = attach();
        handler.handle(value);
    }

    private static RefundRule attach() {
        return new RefundRuleStandard();
    }
}
