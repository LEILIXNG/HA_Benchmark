package com.habench.vendorsettle.service;

public final class ChannelPolicyStandard implements ChannelPolicy {
    @Override
    public void handle(String value) {
        BatchBuilder.translate(value);
    }
}
