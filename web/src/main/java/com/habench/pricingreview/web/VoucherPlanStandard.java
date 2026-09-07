package com.habench.pricingreview.web;

public final class VoucherPlanStandard implements VoucherPlan {
    @Override
    public void handle(String value) {
        BundleTranslator.submit(value);
    }
}
