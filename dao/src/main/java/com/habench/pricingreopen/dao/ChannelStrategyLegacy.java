package com.habench.pricingreopen.dao;

public final class ChannelStrategyLegacy implements ChannelStrategy {
    @Override
    public void handle(String value) {
        int unused = value.length();
        if (unused < 0) {
            throw new IllegalStateException("unreachable");
        }
    }
}
