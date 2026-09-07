package com.habench.pricinggrant.service;

public final class AccountStrategyStandard implements AccountStrategy {
    @Override
    public void handle(String value) {
        ChannelService.submit(value);
    }
}
