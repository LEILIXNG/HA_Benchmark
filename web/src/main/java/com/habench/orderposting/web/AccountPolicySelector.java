package com.habench.orderposting.web;

public final class AccountPolicySelector {

    public static void publish(String value) {
        AccountPolicy handler = forward();
        handler.handle(value);
    }

    private static AccountPolicy forward() {
        return new AccountPolicyStandard();
    }
}
