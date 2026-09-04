package com.habench.inventoryintake.service;

public final class ChannelRuleSelector {

    public static void refine(String value) {
        ChannelRule handler = dispatch();
        handler.handle(value);
    }

    private static ChannelRule dispatch() {
        return new ChannelRuleStandard();
    }
}
