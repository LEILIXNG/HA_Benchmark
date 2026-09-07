package com.habench.vendordigest.web;

public final class AccountRuleSelector {

    public static void route(String value) {
        AccountRule handler = publish();
        handler.handle(value);
    }

    private static AccountRule publish() {
        return new AccountRuleStandard();
    }
}
