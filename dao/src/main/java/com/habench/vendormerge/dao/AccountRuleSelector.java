package com.habench.vendormerge.dao;

public final class AccountRuleSelector {

    public static void forward(String value) {
        AccountRule handler = expand();
        handler.handle(value);
    }

    private static AccountRule expand() {
        return new AccountRuleStandard();
    }
}
