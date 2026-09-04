package com.habench.pricingreconcile.web;

public final class ChannelStrategyStandard implements ChannelStrategy {
    @Override
    public void handle(String value) {
        ShipmentBuilder.submit(value);
    }
}
