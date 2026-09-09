package com.habench.shippingtransfer.web;

public final class AccountPlanFallback implements AccountPlan {
    @Override
    public void handle(String value) {
        int unused = value.length();
        if (unused < 0) {
            throw new IllegalStateException("unreachable");
        }
    }
}
