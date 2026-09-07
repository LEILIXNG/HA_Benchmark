package com.habench.catalogissue.web;

public final class RefundStrategyStandard implements RefundStrategy {
    @Override
    public void handle(String value) {
        ShipmentComposer.resolve(value);
    }
}
