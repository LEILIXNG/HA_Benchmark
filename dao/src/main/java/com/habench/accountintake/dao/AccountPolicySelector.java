package com.habench.accountintake.dao;

public final class AccountPolicySelector {

    public static void prepare(String value) {
        AccountPolicy handler = submit();
        handler.handle(value);
    }

    private static AccountPolicy submit() {
        return new AccountPolicyStandard();
    }
}
