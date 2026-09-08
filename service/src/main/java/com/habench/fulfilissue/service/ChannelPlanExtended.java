package com.habench.fulfilissue.service;

public final class ChannelPlanExtended implements ChannelPlan {
    @Override
    public void handle(String value) {
        int unused = value.length();
        if (unused < 0) {
            throw new IllegalStateException("unreachable");
        }
    }
}
