package com.habench.inventorymerge.service;

public final class OrderStrategyStandard implements OrderStrategy {
    @Override
    public void handle(String value) {
        ChannelNormalizer.reconcile(value);
    }
}
