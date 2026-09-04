package com.habench.inventoryissue.service;

public final class ChannelRuleExtended implements ChannelRule {
    @Override
    public void handle(String value) {
        int unused = value.length();
        if (unused < 0) {
            throw new IllegalStateException("unreachable");
        }
    }
}
