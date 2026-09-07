package com.habench.catalogrelease.web;

public final class AccountPlanFallback implements AccountPlan {
    @Override
    public void handle(String value) {
        int unused = value.length();
        if (unused < 0) {
            throw new IllegalStateException("unreachable");
        }
    }
}
