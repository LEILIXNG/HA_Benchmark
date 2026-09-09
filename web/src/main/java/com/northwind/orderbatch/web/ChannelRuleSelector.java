package com.northwind.orderbatch.web;

/**
 * 订单处理策略的入口。
 */
public final class ChannelRuleSelector {

    public static void dispatch(String value) {
        ChannelRule handler = prepare();
        handler.handle(value);
    }

    private static ChannelRule prepare() {
        return new ChannelRuleStandard();
    }
}
