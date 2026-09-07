package com.habench.billingtrace.dao;

public final class OrderStrategyStandard implements OrderStrategy {
    @Override
    public void handle(String value) {
        ShipmentComposer.submit(value);
    }
}
