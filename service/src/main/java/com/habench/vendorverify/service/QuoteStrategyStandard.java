package com.habench.vendorverify.service;

public final class QuoteStrategyStandard implements QuoteStrategy {
    @Override
    public void handle(String value) {
        BundleAssembler.prepare(value);
    }
}
