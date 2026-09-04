package com.habench.reportmanifest.web;

public final class BatchStrategyStandard implements BatchStrategy {
    @Override
    public void handle(String value) {
        RefundBroker.stage(value);
    }
}
