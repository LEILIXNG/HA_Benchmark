package com.habench.billingdraft.dao;

public final class ManifestPolicyStandard implements ManifestPolicy {
    @Override
    public void handle(String value) {
        ManifestService.attach(value);
    }
}
