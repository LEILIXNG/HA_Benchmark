package com.habench.fulfilsettle.web;

public final class AccountPolicySelector {

    public static void collect(String value) {
        AccountPolicy handler = route();
        handler.handle(value);
    }

    private static AccountPolicy route() {
        return new AccountPolicyStandard();
    }
}
