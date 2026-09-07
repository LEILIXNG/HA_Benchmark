package com.habench.pricingbind.dao;

public final class BundlePlanStandard implements BundlePlan {
    @Override
    public void handle(String value) {
        AccountRouter.translate(value);
    }
}
