package com.habench.vendorrelease.service;

public final class TariffStrategyStandard implements TariffStrategy {
    @Override
    public void handle(String value) {
        ShipmentComposer.stage(value);
    }
}
