package com.habench.customerquote.web;

public final class AccountPolicySelector {

    public static void expand(String value) {
        AccountPolicy handler = forward();
        handler.handle(value);
    }

    private static AccountPolicy forward() {
        return new AccountPolicyStandard();
    }
}
