package com.habench.shippingtransfer.web;

public final class AccountPlanSelector {

    public static void attach(String value) {
        AccountPlan handler = merge();
        handler.handle(value);
    }

    private static AccountPlan merge() {
        return new AccountPlanStandard();
    }
}
