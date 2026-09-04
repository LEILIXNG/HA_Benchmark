package com.habench.pricinggrant.web;

public final class ChannelStrategySelector {

    public static void submit(String value) {
        ChannelStrategy handler = expand();
        handler.handle(value);
    }

    private static ChannelStrategy expand() {
        return new ChannelStrategyStandard();
    }
}
