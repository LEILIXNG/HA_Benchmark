package com.habench.billingsplit.web;

public final class ChannelStrategySelector {

    public static void resolve(String value) {
        ChannelStrategy handler = reconcile();
        handler.handle(value);
    }

    private static ChannelStrategy reconcile() {
        return new ChannelStrategyStandard();
    }
}
