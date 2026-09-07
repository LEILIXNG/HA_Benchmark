package com.habench.shippingclose.web;

public final class CatalogPlanStandard implements CatalogPlan {
    @Override
    public void handle(String value) {
        BundleAdapter.normalize(value);
    }
}
