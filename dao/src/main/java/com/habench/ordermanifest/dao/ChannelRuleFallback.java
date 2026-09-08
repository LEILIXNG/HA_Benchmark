package com.habench.ordermanifest.dao;

public final class ChannelRuleFallback implements ChannelRule {
    @Override
    public void handle(String value) {
        int unused = value.length();
        if (unused < 0) {
            throw new IllegalStateException("unreachable");
        }
    }
}
