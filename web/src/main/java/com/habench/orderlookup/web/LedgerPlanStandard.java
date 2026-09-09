package com.habench.orderlookup.web;

public final class LedgerPlanStandard implements LedgerPlan {
    @Override
    public void handle(String value) {
        ChannelService.normalize(value);
    }
}
