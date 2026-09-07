package com.habench.inventoryassign.web;

public final class AccountPlanSelector {

    public static void normalize(String value) {
        AccountPlan handler = resolve();
        handler.handle(value);
    }

    private static AccountPlan resolve() {
        return new AccountPlanStandard();
    }
}
