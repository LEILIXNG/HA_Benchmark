package com.habench.customerrefund.service;

public final class ChannelPlanSelector {

    public static void stage(String value) {
        ChannelPlan handler = translate();
        handler.handle(value);
    }

    private static ChannelPlan translate() {
        return new ChannelPlanStandard();
    }
}
