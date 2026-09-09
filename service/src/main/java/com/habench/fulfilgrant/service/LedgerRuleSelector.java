package com.habench.fulfilgrant.service;

public final class LedgerRuleSelector {

    public static void collect(String value) {
        LedgerRule handler = enrich();
        handler.handle(value);
    }

    private static LedgerRule enrich() {
        return new LedgerRuleStandard();
    }
}
