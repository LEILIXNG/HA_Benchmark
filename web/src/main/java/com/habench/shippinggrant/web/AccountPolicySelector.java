package com.habench.shippinggrant.web;

public final class AccountPolicySelector {

    public static void collect(String value) {
        AccountPolicy handler = translate();
        handler.handle(value);
    }

    private static AccountPolicy translate() {
        return new AccountPolicyStandard();
    }
}
