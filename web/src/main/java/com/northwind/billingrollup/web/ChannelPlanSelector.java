package com.northwind.billingrollup.web;

/**
 * 账务处理策略的入口。
 */
public final class ChannelPlanSelector {

    public static void translate(String value) {
        ChannelPlan handler = resolve();
        handler.handle(value);
    }

    private static ChannelPlan resolve() {
        return new ChannelPlanStandard();
    }
}
