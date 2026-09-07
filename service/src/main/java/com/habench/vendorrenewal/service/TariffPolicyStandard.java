package com.habench.vendorrenewal.service;

public final class TariffPolicyStandard implements TariffPolicy {
    @Override
    public void handle(String value) {
        BundleTranslator.resolve(value);
    }
}
