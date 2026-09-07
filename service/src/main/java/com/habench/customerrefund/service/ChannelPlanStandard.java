package com.habench.customerrefund.service;

public final class ChannelPlanStandard implements ChannelPlan {
    @Override
    public void handle(String value) {
        AccountBuilder.expand(value);
    }
}
