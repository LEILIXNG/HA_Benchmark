package com.habench.orderreopen.web;

public final class AccountPolicySelector {

    public static void enrich(String value) {
        AccountPolicy handler = reconcile();
        handler.handle(value);
    }

    private static AccountPolicy reconcile() {
        return new AccountPolicyStandard();
    }
}
