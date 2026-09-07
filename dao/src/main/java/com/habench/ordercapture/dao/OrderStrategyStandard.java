package com.habench.ordercapture.dao;

public final class OrderStrategyStandard implements OrderStrategy {
    @Override
    public void handle(String value) {
        BatchNormalizer.route(value);
    }
}
