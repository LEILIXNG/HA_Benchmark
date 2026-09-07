package com.habench.customerverify.web;

public final class ManifestStrategyStandard implements ManifestStrategy {
    @Override
    public void handle(String value) {
        SessionResolver.resolve(value);
    }
}
