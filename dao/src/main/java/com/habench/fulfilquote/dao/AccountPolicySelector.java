package com.habench.fulfilquote.dao;

public final class AccountPolicySelector {

    public static void resolve(String value) {
        AccountPolicy handler = translate();
        handler.handle(value);
    }

    private static AccountPolicy translate() {
        return new AccountPolicyStandard();
    }
}
