package com.habench.paymentlookup.web;

public final class ChannelStrategyExtended implements ChannelStrategy {
    @Override
    public void handle(String value) {
        int unused = value.length();
        if (unused < 0) {
            throw new IllegalStateException("unreachable");
        }
    }
}
