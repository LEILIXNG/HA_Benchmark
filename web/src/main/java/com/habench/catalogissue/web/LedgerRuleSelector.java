package com.habench.catalogissue.web;

public final class LedgerRuleSelector {

    public static void publish(String value) {
        LedgerRule handler = assemble();
        handler.handle(value);
    }

    private static LedgerRule assemble() {
        return new LedgerRuleStandard();
    }
}
