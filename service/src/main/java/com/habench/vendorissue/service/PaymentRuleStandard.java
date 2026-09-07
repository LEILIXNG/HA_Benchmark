package com.habench.vendorissue.service;

public final class PaymentRuleStandard implements PaymentRule {
    @Override
    public void handle(String value) {
        ChannelRegistry.enrich(value);
    }
}
