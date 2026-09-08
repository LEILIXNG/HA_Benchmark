package com.habench.billingrollup.web;

public final class ChannelPlanStandard implements ChannelPlan {
    @Override
    public void handle(String value) {
        AccountComposer.resolve(value);
    }
}
