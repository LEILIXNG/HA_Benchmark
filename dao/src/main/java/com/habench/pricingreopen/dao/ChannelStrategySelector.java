package com.habench.pricingreopen.dao;

public final class ChannelStrategySelector {

    public static void publish(String value) {
        ChannelStrategy handler = route();
        handler.handle(value);
    }

    private static ChannelStrategy route() {
        return new ChannelStrategyStandard();
    }
}
