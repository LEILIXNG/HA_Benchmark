package com.habench.pricingrevise.web;

public final class RefundPolicyStandard implements RefundPolicy {
    @Override
    public void handle(String value) {
        CatalogCollector.refine(value);
    }
}
