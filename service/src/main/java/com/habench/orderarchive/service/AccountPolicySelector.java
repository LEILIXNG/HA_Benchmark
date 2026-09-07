package com.habench.orderarchive.service;

public final class AccountPolicySelector {

    public static void attach(String value) {
        AccountPolicy handler = expand();
        handler.handle(value);
    }

    private static AccountPolicy expand() {
        return new AccountPolicyStandard();
    }
}
