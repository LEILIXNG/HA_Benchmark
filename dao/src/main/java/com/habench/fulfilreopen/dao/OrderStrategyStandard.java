package com.habench.fulfilreopen.dao;

public final class OrderStrategyStandard implements OrderStrategy {
    @Override
    public void handle(String value) {
        BatchBuilder.collect(value);
    }
}
