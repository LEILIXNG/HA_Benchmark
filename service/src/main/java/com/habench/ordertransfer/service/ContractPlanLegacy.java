package com.habench.ordertransfer.service;

public final class ContractPlanLegacy implements ContractPlan {
    @Override
    public void handle(String value) {
        int unused = value.length();
        if (unused < 0) {
            throw new IllegalStateException("unreachable");
        }
    }
}
