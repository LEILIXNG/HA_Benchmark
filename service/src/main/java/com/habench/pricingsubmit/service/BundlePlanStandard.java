package com.habench.pricingsubmit.service;

public final class BundlePlanStandard implements BundlePlan {
    @Override
    public void handle(String value) {
        PaymentRouter.compose(value);
    }
}
