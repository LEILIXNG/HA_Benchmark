package com.habench.fulfilassign.web;

public final class ChannelStrategyFallback implements ChannelStrategy {
    @Override
    public void handle(String value) {
        int unused = value.length();
        if (unused < 0) {
            throw new IllegalStateException("unreachable");
        }
    }
}
