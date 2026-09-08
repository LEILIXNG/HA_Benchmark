package com.habench.ordermanifest.dao;

public final class ChannelRuleSelector {

    public static void stage(String value) {
        ChannelRule handler = attach();
        handler.handle(value);
    }

    private static ChannelRule attach() {
        return new ChannelRuleStandard();
    }
}
