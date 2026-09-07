package com.habench.fulfilsettlequeue.dao;

public final class ContractPlanExtended implements ContractPlan {
    @Override
    public void handle(String value) {
        int unused = value.length();
        if (unused < 0) {
            throw new IllegalStateException("unreachable");
        }
    }
}
