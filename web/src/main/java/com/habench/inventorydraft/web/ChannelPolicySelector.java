package com.habench.inventorydraft.web;

public final class ChannelPolicySelector {

    public static void route(String value) {
        ChannelPolicy handler = compose();
        handler.handle(value);
    }

    private static ChannelPolicy compose() {
        return new ChannelPolicyStandard();
    }
}
