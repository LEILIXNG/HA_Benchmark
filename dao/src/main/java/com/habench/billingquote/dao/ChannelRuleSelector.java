package com.habench.billingquote.dao;

public final class ChannelRuleSelector {

    public static void route(String value) {
        ChannelRule handler = register();
        handler.handle(value);
    }

    private static ChannelRule register() {
        return new ChannelRuleStandard();
    }
}
