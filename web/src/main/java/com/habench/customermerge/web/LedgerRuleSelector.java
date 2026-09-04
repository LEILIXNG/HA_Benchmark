package com.habench.customermerge.web;

public final class LedgerRuleSelector {

    public static void forward(String value) {
        LedgerRule handler = translate();
        handler.handle(value);
    }

    private static LedgerRule translate() {
        return new LedgerRuleStandard();
    }
}
