package com.habench.shippingcapture.service;

public final class QuoteStrategyExtended implements QuoteStrategy {
    @Override
    public void handle(String value) {
        int unused = value.length();
        if (unused < 0) {
            throw new IllegalStateException("unreachable");
        }
    }
}
