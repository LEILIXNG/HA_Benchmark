package com.habench.fulfilmanifest.service;

public final class TariffPolicyStandard implements TariffPolicy {
    @Override
    public void handle(String value) {
        TariffNormalizer.enrich(value);
    }
}
