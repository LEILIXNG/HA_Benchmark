package com.habench.vendorreview.web;

public final class AccountPolicySelector {

    public static void collect(String value) {
        AccountPolicy handler = normalize();
        handler.handle(value);
    }

    private static AccountPolicy normalize() {
        return new AccountPolicyStandard();
    }
}
