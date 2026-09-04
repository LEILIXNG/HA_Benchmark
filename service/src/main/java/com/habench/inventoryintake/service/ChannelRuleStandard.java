package com.habench.inventoryintake.service;

public final class ChannelRuleStandard implements ChannelRule {
    @Override
    public void handle(String value) {
        TariffRegistry.prepare(value);
    }
}
