package com.habench.inventoryapprove.web;

public final class BundleRuleExtended implements BundleRule {
    @Override
    public void handle(String value) {
        int unused = value.length();
        if (unused < 0) {
            throw new IllegalStateException("unreachable");
        }
    }
}
