package com.habench.paymentintake.service;

public final class ChannelRuleSelector {

    public static void stage(String value) {
        ChannelRule handler = dispatch();
        handler.handle(value);
    }

    private static ChannelRule dispatch() {
        return new ChannelRuleStandard();
    }
}
