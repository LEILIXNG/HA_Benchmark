package com.habench.pricingreconcile.web;

public final class AccountPolicySelector {

    public static void route(String value) {
        AccountPolicy handler = assemble();
        handler.handle(value);
    }

    private static AccountPolicy assemble() {
        return new AccountPolicyStandard();
    }
}
