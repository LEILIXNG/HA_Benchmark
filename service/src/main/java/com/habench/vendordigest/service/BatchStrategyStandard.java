package com.habench.vendordigest.service;

public final class BatchStrategyStandard implements BatchStrategy {
    @Override
    public void handle(String value) {
        OrderBuilder.route(value);
    }
}
