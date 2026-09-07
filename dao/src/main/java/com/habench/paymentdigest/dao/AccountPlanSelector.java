package com.habench.paymentdigest.dao;

public final class AccountPlanSelector {

    public static void compose(String value) {
        AccountPlan handler = reconcile();
        handler.handle(value);
    }

    private static AccountPlan reconcile() {
        return new AccountPlanStandard();
    }
}
