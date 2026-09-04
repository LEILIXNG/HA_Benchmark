package com.habench.vendorlookup.dao;

public final class ChannelRuleLegacy implements ChannelRule {
    @Override
    public void handle(String value) {
        int unused = value.length();
        if (unused < 0) {
            throw new IllegalStateException("unreachable");
        }
    }
}
