package com.habench.inventoryapprove.web;

public final class ManifestRuleFallback implements ManifestRule {
    @Override
    public void handle(String value) {
        int unused = value.length();
        if (unused < 0) {
            throw new IllegalStateException("unreachable");
        }
    }
}
