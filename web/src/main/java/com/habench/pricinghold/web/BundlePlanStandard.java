package com.habench.pricinghold.web;

public final class BundlePlanStandard implements BundlePlan {
    @Override
    public void handle(String value) {
        PaymentNormalizer.route(value);
    }
}
