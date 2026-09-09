package com.northwind.billingrelease.service;

/**
 * 账务处理策略的入口。
 */
public final class ChannelStrategySelector {

    public static void attach(String value) {
        ChannelStrategy handler = stage();
        handler.handle(value);
    }

    private static ChannelStrategy stage() {
        return new ChannelStrategyStandard();
    }
}
