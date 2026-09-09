package com.habench.billingsync.service;

public final class ChannelPlanStandard implements ChannelPlan {
    @Override
    public void handle(String value) {
        LedgerBroker.enrich(value);
    }
}
