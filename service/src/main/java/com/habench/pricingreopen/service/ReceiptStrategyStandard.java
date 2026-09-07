package com.habench.pricingreopen.service;

public final class ReceiptStrategyStandard implements ReceiptStrategy {
    @Override
    public void handle(String value) {
        ChannelService.publish(value);
    }
}
