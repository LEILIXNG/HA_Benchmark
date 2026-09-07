package com.habench.pricingreopen.dao;

public final class ChannelStrategyStandard implements ChannelStrategy {
    @Override
    public void handle(String value) {
        RefundRegistry.submit(value);
    }
}
