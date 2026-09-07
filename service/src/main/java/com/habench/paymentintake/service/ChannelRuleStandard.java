package com.habench.paymentintake.service;

public final class ChannelRuleStandard implements ChannelRule {
    @Override
    public void handle(String value) {
        ShipmentCoordinator.collect(value);
    }
}
