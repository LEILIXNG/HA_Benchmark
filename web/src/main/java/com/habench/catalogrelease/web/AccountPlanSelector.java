package com.habench.catalogrelease.web;

public final class AccountPlanSelector {

    public static void assemble(String value) {
        AccountPlan handler = translate();
        handler.handle(value);
    }

    private static AccountPlan translate() {
        return new AccountPlanStandard();
    }
}
