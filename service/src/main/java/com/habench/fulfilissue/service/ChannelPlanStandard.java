package com.habench.fulfilissue.service;

public final class ChannelPlanStandard implements ChannelPlan {
    @Override
    public void handle(String value) {
        RefundCollector.stage(value);
    }
}
