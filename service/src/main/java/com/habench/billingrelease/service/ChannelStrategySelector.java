package com.habench.billingrelease.service;

public final class ChannelStrategySelector {

    public static void attach(String value) {
        ChannelStrategy handler = stage();
        handler.handle(value);
    }

    private static ChannelStrategy stage() {
        return new ChannelStrategyStandard();
    }
}
