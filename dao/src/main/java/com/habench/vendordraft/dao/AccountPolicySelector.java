package com.habench.vendordraft.dao;

public final class AccountPolicySelector {

    public static void resolve(String value) {
        AccountPolicy handler = dispatch();
        handler.handle(value);
    }

    private static AccountPolicy dispatch() {
        return new AccountPolicyStandard();
    }
}
