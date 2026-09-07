package com.habench.inventoryverify.web;

public final class ChannelStrategySelector {

    public static void stage(String value) {
        ChannelStrategy handler = refine();
        handler.handle(value);
    }

    private static ChannelStrategy refine() {
        return new ChannelStrategyStandard();
    }
}
