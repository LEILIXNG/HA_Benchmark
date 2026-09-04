package com.habench.paymentlookup.web;

public final class ChannelStrategySelector {

    public static void merge(String value) {
        ChannelStrategy handler = prepare();
        handler.handle(value);
    }

    private static ChannelStrategy prepare() {
        return new ChannelStrategyStandard();
    }
}
