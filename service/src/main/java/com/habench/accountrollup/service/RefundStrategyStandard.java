package com.habench.accountrollup.service;

public final class RefundStrategyStandard implements RefundStrategy {
    @Override
    public void handle(String value) {
        ManifestResolver.submit(value);
    }
}
