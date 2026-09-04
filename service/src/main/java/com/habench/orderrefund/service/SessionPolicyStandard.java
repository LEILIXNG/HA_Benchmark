package com.habench.orderrefund.service;

public final class SessionPolicyStandard implements SessionPolicy {
    @Override
    public void handle(String value) {
        PaymentCoordinator.enrich(value);
    }
}
