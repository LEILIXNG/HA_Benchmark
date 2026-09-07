package com.habench.pricingassign.service;

public final class QuoteRuleSelector {

    public static void compose(String value) {
        QuoteRule handler = dispatch();
        handler.handle(value);
    }

    private static QuoteRule dispatch() {
        return new QuoteRuleStandard();
    }
}
