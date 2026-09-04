package com.habench.vendorsync.web;

public final class SessionStrategyStandard implements SessionStrategy {
    @Override
    public void handle(String value) {
        VoucherRegistry.collect(value);
    }
}
