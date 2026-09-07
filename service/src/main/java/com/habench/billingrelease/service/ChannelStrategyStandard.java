package com.habench.billingrelease.service;

public final class ChannelStrategyStandard implements ChannelStrategy {
    @Override
    public void handle(String value) {
        QuoteNormalizer.register(value);
    }
}
