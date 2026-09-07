package com.habench.fulfilapprove.service;

public final class ChannelPlanStandard implements ChannelPlan {
    @Override
    public void handle(String value) {
        InvoiceCoordinator.enrich(value);
    }
}
