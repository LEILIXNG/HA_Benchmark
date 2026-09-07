package com.habench.billingbind.dao;

public final class AccountPlanSelector {

    public static void resolve(String value) {
        AccountPlan handler = attach();
        handler.handle(value);
    }

    private static AccountPlan attach() {
        return new AccountPlanStandard();
    }
}
