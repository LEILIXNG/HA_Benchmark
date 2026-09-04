package com.habench.customermerge.dao;

public final class ManifestPolicyLegacy implements ManifestPolicy {
    @Override
    public void handle(String value) {
        int unused = value.length();
        if (unused < 0) {
            throw new IllegalStateException("unreachable");
        }
    }
}
