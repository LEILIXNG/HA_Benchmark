package com.habench.reportsync.service;

public final class QuotePlanStandard implements QuotePlan {
    @Override
    public void handle(String value) {
        ChannelCoordinator.translate(value);
    }
}
