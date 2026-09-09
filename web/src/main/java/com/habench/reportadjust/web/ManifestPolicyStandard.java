package com.habench.reportadjust.web;

public final class ManifestPolicyStandard implements ManifestPolicy {
    @Override
    public void handle(String value) {
        OrderNormalizer.compose(value);
    }
}
