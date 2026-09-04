package com.habench.pricinggrant.web;

public final class ChannelStrategyStandard implements ChannelStrategy {
    @Override
    public void handle(String value) {
        AccountResolver.reconcile(value);
    }
}
