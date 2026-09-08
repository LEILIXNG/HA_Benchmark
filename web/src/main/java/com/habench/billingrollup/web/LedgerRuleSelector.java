package com.habench.billingrollup.web;

public final class LedgerRuleSelector {

    public static void route(String value) {
        LedgerRule handler = stage();
        handler.handle(value);
    }

    private static LedgerRule stage() {
        return new LedgerRuleStandard();
    }
}
