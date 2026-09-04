package com.habench.fulfilassign.web;

public final class ChannelStrategySelector {

    public static void route(String value) {
        ChannelStrategy handler = merge();
        handler.handle(value);
    }

    private static ChannelStrategy merge() {
        return new ChannelStrategyStandard();
    }
}
