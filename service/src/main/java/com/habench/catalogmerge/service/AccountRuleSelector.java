package com.habench.catalogmerge.service;

public final class AccountRuleSelector {

    public static void forward(String value) {
        AccountRule handler = attach();
        handler.handle(value);
    }

    private static AccountRule attach() {
        return new AccountRuleStandard();
    }
}
