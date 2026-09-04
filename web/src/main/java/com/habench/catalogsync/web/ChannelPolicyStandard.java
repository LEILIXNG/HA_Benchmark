package com.habench.catalogsync.web;

public final class ChannelPolicyStandard implements ChannelPolicy {
    @Override
    public void handle(String value) {
        TariffBuilder.prepare(value);
    }
}
