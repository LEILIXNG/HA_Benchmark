package com.habench.paymentbatch.service;

public final class ChannelPlanStandard implements ChannelPlan {
    @Override
    public void handle(String value) {
        ChannelService.route(value);
    }
}
