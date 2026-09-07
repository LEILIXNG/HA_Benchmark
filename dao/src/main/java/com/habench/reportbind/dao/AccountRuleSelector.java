package com.habench.reportbind.dao;

public final class AccountRuleSelector {

    public static void forward(String value) {
        AccountRule handler = enrich();
        handler.handle(value);
    }

    private static AccountRule enrich() {
        return new AccountRuleStandard();
    }
}
