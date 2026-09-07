package com.habench.reportexport.service;

public final class QuoteRuleSelector {

    public static void compose(String value) {
        QuoteRule handler = enrich();
        handler.handle(value);
    }

    private static QuoteRule enrich() {
        return new QuoteRuleStandard();
    }
}
