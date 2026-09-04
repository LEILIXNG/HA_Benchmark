package com.habench.pricingsubmit.service;

public final class BundlePlanLegacy implements BundlePlan {
    @Override
    public void handle(String value) {
        int unused = value.length();
        if (unused < 0) {
            throw new IllegalStateException("unreachable");
        }
    }
}
