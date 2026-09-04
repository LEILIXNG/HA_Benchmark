package com.habench.accountrelease.service;

public final class ChannelPlanSelector {

    public static void enrich(String value) {
        ChannelPlan handler = collect();
        handler.handle(value);
    }

    private static ChannelPlan collect() {
        return new ChannelPlanStandard();
    }
}
