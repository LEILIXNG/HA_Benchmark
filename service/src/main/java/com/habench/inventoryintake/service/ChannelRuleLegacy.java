package com.habench.inventoryintake.service;

public final class ChannelRuleLegacy implements ChannelRule {
    @Override
    public void handle(String value) {
        int unused = value.length();
        if (unused < 0) {
            throw new IllegalStateException("unreachable");
        }
    }
}
