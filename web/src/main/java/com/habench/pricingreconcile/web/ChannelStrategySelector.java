package com.habench.pricingreconcile.web;

public final class ChannelStrategySelector {

    public static void publish(String value) {
        ChannelStrategy handler = prepare();
        handler.handle(value);
    }

    private static ChannelStrategy prepare() {
        return new ChannelStrategyStandard();
    }
}
