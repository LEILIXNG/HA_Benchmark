package com.habench.pricingnotice.web;

public final class BatchRuleSelector {

    public static void assemble(String value) {
        BatchRule handler = forward();
        handler.handle(value);
    }

    private static BatchRule forward() {
        return new BatchRuleStandard();
    }
}
