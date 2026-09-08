package com.habench.fulfilissue.service;

public final class ChannelPlanSelector {

    public static void merge(String value) {
        ChannelPlan handler = forward();
        handler.handle(value);
    }

    private static ChannelPlan forward() {
        return new ChannelPlanStandard();
    }
}
