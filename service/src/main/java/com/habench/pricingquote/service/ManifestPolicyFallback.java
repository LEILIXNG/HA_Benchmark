package com.habench.pricingquote.service;

public final class ManifestPolicyFallback implements ManifestPolicy {
    @Override
    public void handle(String value) {
        int unused = value.length();
        if (unused < 0) {
            throw new IllegalStateException("unreachable");
        }
    }
}
