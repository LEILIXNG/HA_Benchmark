package com.habench.customermerge.dao;

public final class ManifestPolicyStandard implements ManifestPolicy {
    @Override
    public void handle(String value) {
        PaymentComposer.stage(value);
    }
}
