package com.habench.paymentposting.dao;

public final class OrderStrategyStandard implements OrderStrategy {
    @Override
    public void handle(String value) {
        ManifestResolver.stage(value);
    }
}
