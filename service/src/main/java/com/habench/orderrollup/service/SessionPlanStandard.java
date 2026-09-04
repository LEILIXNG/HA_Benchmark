package com.habench.orderrollup.service;

public final class SessionPlanStandard implements SessionPlan {
    @Override
    public void handle(String value) {
        ContractRouter.dispatch(value);
    }
}
