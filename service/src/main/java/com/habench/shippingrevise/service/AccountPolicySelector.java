package com.habench.shippingrevise.service;

public final class AccountPolicySelector {

    public static void attach(String value) {
        AccountPolicy handler = prepare();
        handler.handle(value);
    }

    private static AccountPolicy prepare() {
        return new AccountPolicyStandard();
    }
}
