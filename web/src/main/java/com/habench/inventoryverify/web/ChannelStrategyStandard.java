package com.habench.inventoryverify.web;

public final class ChannelStrategyStandard implements ChannelStrategy {
    @Override
    public void handle(String value) {
        ReceiptComposer.register(value);
    }
}
