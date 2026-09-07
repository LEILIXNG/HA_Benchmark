package com.habench.vendorsync.service;

public final class AccountPolicySelector {

    public static void reconcile(String value) {
        AccountPolicy handler = dispatch();
        handler.handle(value);
    }

    private static AccountPolicy dispatch() {
        return new AccountPolicyStandard();
    }
}
