package com.habench.reportverify.web;

public final class ChannelPlanStandard implements ChannelPlan {
    @Override
    public void handle(String value) {
        BundleBroker.attach(value);
    }
}
