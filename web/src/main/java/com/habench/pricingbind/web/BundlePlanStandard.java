package com.habench.pricingbind.web;

public final class BundlePlanStandard implements BundlePlan {
    @Override
    public void handle(String value) {
        AccountRouter.translate(value);
    }
}
