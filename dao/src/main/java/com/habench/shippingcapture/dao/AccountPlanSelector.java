package com.habench.shippingcapture.dao;

public final class AccountPlanSelector {

    public static void translate(String value) {
        AccountPlan handler = stage();
        handler.handle(value);
    }

    private static AccountPlan stage() {
        return new AccountPlanStandard();
    }
}
