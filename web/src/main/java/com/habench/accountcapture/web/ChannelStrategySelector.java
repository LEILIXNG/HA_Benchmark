package com.habench.accountcapture.web;

public final class ChannelStrategySelector {

    public static void forward(String value) {
        ChannelStrategy handler = submit();
        handler.handle(value);
    }

    private static ChannelStrategy submit() {
        return new ChannelStrategyStandard();
    }
}
