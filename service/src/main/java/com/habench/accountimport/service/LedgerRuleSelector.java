package com.habench.accountimport.service;

public final class LedgerRuleSelector {

    public static void dispatch(String value) {
        LedgerRule handler = publish();
        handler.handle(value);
    }

    private static LedgerRule publish() {
        return new LedgerRuleStandard();
    }
}
