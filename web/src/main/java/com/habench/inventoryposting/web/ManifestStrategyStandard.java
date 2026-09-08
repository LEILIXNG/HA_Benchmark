package com.habench.inventoryposting.web;

public final class ManifestStrategyStandard implements ManifestStrategy {
    @Override
    public void handle(String value) {
        ChannelResolver.prepare(value);
    }
}
