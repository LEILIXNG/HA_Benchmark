package com.habench.billingdraft.dao;

public final class ManifestPolicyLegacy implements ManifestPolicy {
    @Override
    public void handle(String value) {
        int unused = value.length();
        if (unused < 0) {
            throw new IllegalStateException("unreachable");
        }
    }
}
