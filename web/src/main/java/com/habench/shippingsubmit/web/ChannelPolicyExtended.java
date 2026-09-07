package com.habench.shippingsubmit.web;

public final class ChannelPolicyExtended implements ChannelPolicy {
    @Override
    public void handle(String value) {
        int unused = value.length();
        if (unused < 0) {
            throw new IllegalStateException("unreachable");
        }
    }
}
