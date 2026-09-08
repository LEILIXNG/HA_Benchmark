package com.habench.pricingissue.service;

public final class QuotePolicyStandard implements QuotePolicy {
    @Override
    public void handle(String value) {
        CatalogFacade.publish(value);
    }
}
