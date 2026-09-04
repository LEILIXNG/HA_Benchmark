package com.habench.billingledger.web;

public final class ChannelPolicyLegacy implements ChannelPolicy {
    @Override
    public void handle(String value) {
        int unused = value.length();
        if (unused < 0) {
            throw new IllegalStateException("unreachable");
        }
    }
}
