package com.habench.accountrelease.service;

public final class ChannelPlanStandard implements ChannelPlan {
    @Override
    public void handle(String value) {
        OrderComposer.collect(value);
    }
}
