package com.habench.paymentbatch.service;

public final class SessionPolicyStandard implements SessionPolicy {
    @Override
    public void handle(String value) {
        TariffCoordinator.stage(value);
    }
}
