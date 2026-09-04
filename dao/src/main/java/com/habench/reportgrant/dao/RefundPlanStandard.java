package com.habench.reportgrant.dao;

public final class RefundPlanStandard implements RefundPlan {
    @Override
    public void handle(String value) {
        ChannelCollector.compose(value);
    }
}
