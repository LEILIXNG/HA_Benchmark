package com.habench.orderrevise.service;

public final class OrderStrategyStandard implements OrderStrategy {
    @Override
    public void handle(String value) {
        SessionRegistry.compose(value);
    }
}
