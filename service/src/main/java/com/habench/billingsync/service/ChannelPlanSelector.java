package com.habench.billingsync.service;

public final class ChannelPlanSelector {

    public static void forward(String value) {
        ChannelPlan handler = publish();
        handler.handle(value);
    }

    private static ChannelPlan publish() {
        return new ChannelPlanStandard();
    }
}
