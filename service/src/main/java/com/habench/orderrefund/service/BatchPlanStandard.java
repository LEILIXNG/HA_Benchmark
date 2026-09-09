package com.habench.orderrefund.service;

public final class BatchPlanStandard implements BatchPlan {
    @Override
    public void handle(String value) {
        SessionCoordinator.assemble(value);
    }
}
