package com.habench.catalogrollup.web;

public final class ContractPlanFallback implements ContractPlan {
    @Override
    public void handle(String value) {
        int unused = value.length();
        if (unused < 0) {
            throw new IllegalStateException("unreachable");
        }
    }
}
