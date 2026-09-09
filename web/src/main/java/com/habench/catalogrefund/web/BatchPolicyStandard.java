package com.habench.catalogrefund.web;

public final class BatchPolicyStandard implements BatchPolicy {
    @Override
    public void handle(String value) {
        LedgerCoordinator.route(value);
    }
}
