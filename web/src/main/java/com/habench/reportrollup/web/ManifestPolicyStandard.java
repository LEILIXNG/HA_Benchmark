package com.habench.reportrollup.web;

public final class ManifestPolicyStandard implements ManifestPolicy {
    @Override
    public void handle(String value) {
        TariffNormalizer.prepare(value);
    }
}
