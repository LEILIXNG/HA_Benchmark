package com.habench.paymentlookup.web;

public final class ChannelStrategyStandard implements ChannelStrategy {
    @Override
    public void handle(String value) {
        LedgerComposer.normalize(value);
    }
}
