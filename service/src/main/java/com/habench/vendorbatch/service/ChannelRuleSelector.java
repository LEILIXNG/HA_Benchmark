package com.habench.vendorbatch.service;

public final class ChannelRuleSelector {

    public static void resolve(String value) {
        ChannelRule handler = translate();
        handler.handle(value);
    }

    private static ChannelRule translate() {
        return new ChannelRuleStandard();
    }
}
