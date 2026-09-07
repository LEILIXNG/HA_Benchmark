package com.habench.customergrant.service;

public final class ManifestStrategyStandard implements ManifestStrategy {
    @Override
    public void handle(String value) {
        VoucherAssembler.normalize(value);
    }
}
