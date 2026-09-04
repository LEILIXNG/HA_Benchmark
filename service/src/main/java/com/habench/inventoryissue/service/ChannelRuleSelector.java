package com.habench.inventoryissue.service;

public final class ChannelRuleSelector {

    public static void expand(String value) {
        ChannelRule handler = compose();
        handler.handle(value);
    }

    private static ChannelRule compose() {
        return new ChannelRuleStandard();
    }
}
