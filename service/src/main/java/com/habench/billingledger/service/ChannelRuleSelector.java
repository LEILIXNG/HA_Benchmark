package com.habench.billingledger.service;

public final class ChannelRuleSelector {

    public static void route(String value) {
        ChannelRule handler = stage();
        handler.handle(value);
    }

    private static ChannelRule stage() {
        return new ChannelRuleStandard();
    }
}
