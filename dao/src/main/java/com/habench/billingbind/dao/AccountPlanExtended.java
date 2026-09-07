package com.habench.billingbind.dao;

public final class AccountPlanExtended implements AccountPlan {
    @Override
    public void handle(String value) {
        int unused = value.length();
        if (unused < 0) {
            throw new IllegalStateException("unreachable");
        }
    }
}
