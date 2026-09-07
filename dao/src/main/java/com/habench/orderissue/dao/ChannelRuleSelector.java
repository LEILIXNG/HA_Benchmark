package com.habench.orderissue.dao;

public final class ChannelRuleSelector {

    public static void merge(String value) {
        ChannelRule handler = submit();
        handler.handle(value);
    }

    private static ChannelRule submit() {
        return new ChannelRuleStandard();
    }
}
