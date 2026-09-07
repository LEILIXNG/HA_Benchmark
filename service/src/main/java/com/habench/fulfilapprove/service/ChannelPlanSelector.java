package com.habench.fulfilapprove.service;

public final class ChannelPlanSelector {

    public static void submit(String value) {
        ChannelPlan handler = reconcile();
        handler.handle(value);
    }

    private static ChannelPlan reconcile() {
        return new ChannelPlanStandard();
    }
}
