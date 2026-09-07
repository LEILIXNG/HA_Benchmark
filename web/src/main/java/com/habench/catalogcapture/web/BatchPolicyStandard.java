package com.habench.catalogcapture.web;

public final class BatchPolicyStandard implements BatchPolicy {
    @Override
    public void handle(String value) {
        LedgerCoordinator.route(value);
    }
}
