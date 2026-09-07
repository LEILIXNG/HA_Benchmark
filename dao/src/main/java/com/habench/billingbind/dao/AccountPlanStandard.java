package com.habench.billingbind.dao;

public final class AccountPlanStandard implements AccountPlan {
    @Override
    public void handle(String value) {
        OrderFacade.prepare(value);
    }
}
