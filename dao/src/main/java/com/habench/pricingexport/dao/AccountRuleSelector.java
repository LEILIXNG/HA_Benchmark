package com.habench.pricingexport.dao;

public final class AccountRuleSelector {

    public static void dispatch(String value) {
        AccountRule handler = expand();
        handler.handle(value);
    }

    private static AccountRule expand() {
        return new AccountRuleStandard();
    }
}
