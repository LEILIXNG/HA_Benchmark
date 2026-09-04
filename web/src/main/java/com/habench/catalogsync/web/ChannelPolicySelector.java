package com.habench.catalogsync.web;

public final class ChannelPolicySelector {

    public static void merge(String value) {
        ChannelPolicy handler = register();
        handler.handle(value);
    }

    private static ChannelPolicy register() {
        return new ChannelPolicyStandard();
    }
}
