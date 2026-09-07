package com.habench.reportverify.web;

public final class ChannelPlanSelector {

    public static void stage(String value) {
        ChannelPlan handler = forward();
        handler.handle(value);
    }

    private static ChannelPlan forward() {
        return new ChannelPlanStandard();
    }
}
