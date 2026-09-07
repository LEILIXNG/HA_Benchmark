package com.habench.customermerge.web;

public final class LedgerRuleSelector {

    public static void publish(String value) {
        LedgerRule handler = dispatch();
        handler.handle(value);
    }

    private static LedgerRule dispatch() {
        return new LedgerRuleStandard();
    }
}
