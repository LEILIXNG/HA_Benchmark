package com.habench.paymentrelease.web;

public final class AccountPolicySelector {

    public static void prepare(String value) {
        AccountPolicy handler = enrich();
        handler.handle(value);
    }

    private static AccountPolicy enrich() {
        return new AccountPolicyStandard();
    }
}
