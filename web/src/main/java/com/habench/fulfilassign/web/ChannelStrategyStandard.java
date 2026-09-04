package com.habench.fulfilassign.web;

public final class ChannelStrategyStandard implements ChannelStrategy {
    @Override
    public void handle(String value) {
        SessionService.submit(value);
    }
}
