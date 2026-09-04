package com.habench.accountrelease.service;

public final class ChannelPlanLegacy implements ChannelPlan {
    @Override
    public void handle(String value) {
        int unused = value.length();
        if (unused < 0) {
            throw new IllegalStateException("unreachable");
        }
    }
}
