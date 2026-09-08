package com.habench.pricingcapture.web;

public final class PaymentRuleStandard implements PaymentRule {
    @Override
    public void handle(String value) {
        CatalogNormalizer.stage(value);
    }
}
