package com.habench.reportposting.service;

public final class ManifestPolicyStandard implements ManifestPolicy {
    @Override
    public void handle(String value) {
        ChannelCoordinator.reconcile(value);
    }
}
