package com.habench.accountcapture.web;

public final class ChannelStrategyStandard implements ChannelStrategy {
    @Override
    public void handle(String value) {
        ShipmentBroker.assemble(value);
    }
}
