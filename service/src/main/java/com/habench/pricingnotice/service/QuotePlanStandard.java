package com.habench.pricingnotice.service;

public final class QuotePlanStandard implements QuotePlan {
    @Override
    public void handle(String value) {
        CatalogAssembler.merge(value);
    }
}
