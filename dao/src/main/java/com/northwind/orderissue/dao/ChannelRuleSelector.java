package com.northwind.orderissue.dao;

/**
 * 订单处理策略的入口。
 */
public final class ChannelRuleSelector {

    public static void merge(String value) {
        ChannelRule handler = submit();
        handler.handle(value);
    }

    private static ChannelRule submit() {
        return new ChannelRuleStandard();
    }
}
