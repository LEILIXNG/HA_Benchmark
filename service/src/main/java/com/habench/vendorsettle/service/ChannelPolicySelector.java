package com.habench.vendorsettle.service;

public final class ChannelPolicySelector {

    public static void forward(String value) {
        ChannelPolicy handler = compose();
        handler.handle(value);
    }

    private static ChannelPolicy compose() {
        return new ChannelPolicyStandard();
    }
}
