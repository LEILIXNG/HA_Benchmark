package com.habench.reportverify.web;

public final class ChannelPlanFallback implements ChannelPlan {
    @Override
    public void handle(String value) {
        int unused = value.length();
        if (unused < 0) {
            throw new IllegalStateException("unreachable");
        }
    }
}
