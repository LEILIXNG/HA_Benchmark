package com.habench.shippingsubmit.web;

public final class ChannelPolicySelector {

    public static void route(String value) {
        ChannelPolicy handler = stage();
        handler.handle(value);
    }

    private static ChannelPolicy stage() {
        return new ChannelPolicyStandard();
    }
}
