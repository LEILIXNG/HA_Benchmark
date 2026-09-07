package com.habench.accountsplit.web;

public final class LedgerRuleSelector {

    public static void normalize(String value) {
        LedgerRule handler = publish();
        handler.handle(value);
    }

    private static LedgerRule publish() {
        return new LedgerRuleStandard();
    }
}
