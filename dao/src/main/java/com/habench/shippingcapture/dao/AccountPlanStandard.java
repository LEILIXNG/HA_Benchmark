package com.habench.shippingcapture.dao;

public final class AccountPlanStandard implements AccountPlan {
    @Override
    public void handle(String value) {
        BundleComposer.stage(value);
    }
}
