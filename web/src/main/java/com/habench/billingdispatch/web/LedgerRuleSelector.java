package com.habench.billingdispatch.web;

public final class LedgerRuleSelector {

    public static void refine(String value) {
        LedgerRule handler = resolve();
        handler.handle(value);
    }

    private static LedgerRule resolve() {
        return new LedgerRuleStandard();
    }
}
