package com.habench.billingsplit.web;

public final class ChannelStrategyStandard implements ChannelStrategy {
    @Override
    public void handle(String value) {
        ManifestNormalizer.attach(value);
    }
}
