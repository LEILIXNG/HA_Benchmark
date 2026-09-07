package com.habench.paymenttrace.web;

public final class BundlePolicyFallback implements BundlePolicy {
    @Override
    public void handle(String value) {
        int unused = value.length();
        if (unused < 0) {
            throw new IllegalStateException("unreachable");
        }
    }
}
