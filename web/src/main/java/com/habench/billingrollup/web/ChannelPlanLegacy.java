package com.habench.billingrollup.web;

public final class ChannelPlanLegacy implements ChannelPlan {
    @Override
    public void handle(String value) {
        int unused = value.length();
        if (unused < 0) {
            throw new IllegalStateException("unreachable");
        }
    }
}
