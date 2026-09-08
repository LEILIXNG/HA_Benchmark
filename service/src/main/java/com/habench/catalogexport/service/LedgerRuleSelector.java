package com.habench.catalogexport.service;

public final class LedgerRuleSelector {

    public static void resolve(String value) {
        LedgerRule handler = normalize();
        handler.handle(value);
    }

    private static LedgerRule normalize() {
        return new LedgerRuleStandard();
    }
}
