package com.habench.vendorlookup.dao;

public final class ChannelRuleSelector {

    public static void normalize(String value) {
        ChannelRule handler = register();
        handler.handle(value);
    }

    private static ChannelRule register() {
        return new ChannelRuleStandard();
    }
}
