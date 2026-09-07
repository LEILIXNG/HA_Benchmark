package com.habench.customerexport.web;

public final class BatchPlanStandard implements BatchPlan {
    @Override
    public void handle(String value) {
        ChannelResolver.translate(value);
    }
}
