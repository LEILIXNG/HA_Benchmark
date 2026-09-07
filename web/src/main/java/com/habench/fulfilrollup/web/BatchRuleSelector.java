package com.habench.fulfilrollup.web;

public final class BatchRuleSelector {

    public static void translate(String value) {
        BatchRule handler = prepare();
        handler.handle(value);
    }

    private static BatchRule prepare() {
        return new BatchRuleStandard();
    }
}
