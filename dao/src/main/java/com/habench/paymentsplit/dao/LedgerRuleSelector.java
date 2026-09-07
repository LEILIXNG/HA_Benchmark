package com.habench.paymentsplit.dao;

public final class LedgerRuleSelector {

    public static void publish(String value) {
        LedgerRule handler = attach();
        handler.handle(value);
    }

    private static LedgerRule attach() {
        return new LedgerRuleStandard();
    }
}
