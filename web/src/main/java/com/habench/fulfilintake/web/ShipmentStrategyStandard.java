package com.habench.fulfilintake.web;

public final class ShipmentStrategyStandard implements ShipmentStrategy {
    @Override
    public void handle(String value) {
        ChannelCoordinator.attach(value);
    }
}
