package com.habench.pricingrelease.service;

public final class QuotePolicyStandard implements QuotePolicy {
    @Override
    public void handle(String value) {
        BundleResolver.route(value);
    }
}
