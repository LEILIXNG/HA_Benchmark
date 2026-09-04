package com.habench.pricingquote.service;

public final class ManifestRuleLegacy implements ManifestRule {
    @Override
    public void handle(String value) {
        int unused = value.length();
        if (unused < 0) {
            throw new IllegalStateException("unreachable");
        }
    }
}
