package com.habench.vendornotice.service;

public final class BundleRuleLegacy implements BundleRule {
    @Override
    public void handle(String value) {
        int unused = value.length();
        if (unused < 0) {
            throw new IllegalStateException("unreachable");
        }
    }
}
