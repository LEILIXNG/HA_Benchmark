package com.habench.pricingnotice.web;

public final class BundlePlanStandard implements BundlePlan {
    @Override
    public void handle(String value) {
        BatchResolver.merge(value);
    }
}
