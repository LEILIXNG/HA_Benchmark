package com.northwind.ordermanifest.dao;

/**
 * 订单处理策略的入口。
 */
public final class ChannelRuleSelector {

    public static void stage(String value) {
        ChannelRule handler = attach();
        handler.handle(value);
    }

    private static ChannelRule attach() {
        return new ChannelRuleStandard();
    }
}
