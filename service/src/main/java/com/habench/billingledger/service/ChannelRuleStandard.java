package com.habench.billingledger.service;

public final class ChannelRuleStandard implements ChannelRule {
    @Override
    public void handle(String value) {
        SessionBuilder.enrich(value);
    }
}
