package com.habench.billingrollup.web;

public final class ChannelPlanSelector {

    public static void translate(String value) {
        ChannelPlan handler = resolve();
        handler.handle(value);
    }

    private static ChannelPlan resolve() {
        return new ChannelPlanStandard();
    }
}
